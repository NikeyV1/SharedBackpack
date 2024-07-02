package de.nikey.sharedbackpack.utils;

import de.nikey.sharedbackpack.SharedBackpack;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Backpack implements Listener {
    public static HashMap<String, Inventory> invMenu = new HashMap<>();


    public static void saveBackpackToConfig() {
        for (int i = 0; i < SharedBackpack.backpackInventory.getSize(); i++) {
            ItemStack item = SharedBackpack.backpackInventory.getItem(i);
            if (item != null) {
                SharedBackpack.getPlugin().getConfig().set("backpack.slot" + i, item);
            } else {
                SharedBackpack.getPlugin().getConfig().set("backpack.slot" + i, null);
            }
        }
    }

    public static void loadBackpackFromConfig() {
        for (int i = 0; i < SharedBackpack.backpackInventory.getSize(); i++) {
            if (SharedBackpack.getPlugin().getConfig().contains("backpack.slot" + i)) {
                SharedBackpack.backpackInventory.setItem(i, SharedBackpack.getPlugin().getConfig().getItemStack("backpack.slot" + i));
            }
        }
    }
}
