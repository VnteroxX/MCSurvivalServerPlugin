package me.luciid.survivalserver;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class GrenadeListener implements Listener {

    private Main plugin;

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getMaterial() == Material.TNT) {
                if(player.getInventory().getItemInMainHand().getAmount() == 1) {
                    player.getInventory().remove(Material.TNT);
                    return;
                }

                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() -1);
                final Item tnt = player.getWorld().dropItem(player.getEyeLocation(), new ItemStack(Material.TNT));
                tnt.setVelocity(player.getLocation().getDirection().multiply(2D));

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        tnt.getWorld().createExplosion(tnt.getLocation().getX(), tnt.getLocation().getY(), tnt.getLocation().getZ(), 3, false, false);
                    }
                }, 20*3);
            }
        }
    }
}
