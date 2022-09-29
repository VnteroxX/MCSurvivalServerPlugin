package me.luciid.survivalserver.backpack;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;
            ItemStack holdByPlayer = player.getItemInHand();

            player.sendMessage("§8[Debug] /inv Befehl erfolgreich geladen");

            if(holdByPlayer == Material.BOOK) {

            }

        }

        return false;
    }
}
