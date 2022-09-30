package me.luciid.survivalserver.backpack;

import me.luciid.survivalserver.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BackpackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(args.length != 1) {
                player.sendMessage("§cDu vollmongo versuch mal §6/backpack <Name des Rucksacks>");
                return true;
            }
            if(player.getInventory().getItemInMainHand().getType() == Material.BOOK) {
                if(player.getInventory().getItemInMainHand().getAmount() == 1) {


                    ItemStack backpackItem = player.getInventory().getItemInMainHand();
                    String backpackName = args[0];
                    ItemMeta backpackMeta = backpackItem.getItemMeta();

                    ArrayList<String> backpackLore = new ArrayList<String>();

                    backpackLore.add("§eRucksack von §6" + player.getDisplayName());
                    backpackLore.set(1, "Debug");
                    backpackMeta.setDisplayName(backpackName);
                    backpackMeta.setLore(backpackLore);

                    //player.getInventory().setItem(player.getInventory().getHeldItemSlot(), backpackItem);

                    player.sendMessage("§aDer Rucksack §6" + backpackName + " §awurde erfolgreich erstellt!");

                } else {
                    player.sendMessage("§cDu Spasst kannst nur ein einzelnes Buch zu einem Rucksack machen.");
                }
            } else {
                player.sendMessage("§cEinen Rucksack kannst du nur mit einem Buch erstellen.");
            }
        }
        return false;
    }
}
