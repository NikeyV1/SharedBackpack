package de.nikey.sharedbackpack.utils;

import de.nikey.sharedbackpack.SharedBackpack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Inventar dem Spieler öffnen
            player.openInventory(SharedBackpack.backpackInventory);
            return true;
        } else {
            return false;
        }
    }
}
