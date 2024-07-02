package de.nikey.sharedbackpack;

import de.nikey.sharedbackpack.utils.Backpack;
import de.nikey.sharedbackpack.utils.BackpackCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class SharedBackpack extends JavaPlugin {

    private static SharedBackpack plugin;
    public static Inventory backpackInventory;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        plugin = this;

        // Config laden
        this.saveDefaultConfig();
        config = this.getConfig();

        // Inventar mit 4 Reihen (36 Slots) erstellen
        backpackInventory = Bukkit.createInventory(null, 36, "Backpack");

        // Inventar aus der Config laden
        Backpack.loadBackpackFromConfig();

        // Command registrieren
        this.getCommand("backpack").setExecutor(new BackpackCommand());
    }

    @Override
    public void onDisable() {
        // Inventar in die Config speichern
        Backpack.saveBackpackToConfig();
        this.saveConfig();
    }

    public static SharedBackpack getPlugin() {
        return plugin;
    }
}
