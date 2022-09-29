package me.luciid.survivalserver.backpack;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BackpackListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getItem() == null) return;

        Player player = event.getPlayer();

        player.sendMessage("§8[Debug] Einzelnes Buch erkannt.");
        //Hier dann das Inventar Öffnen

    }
}
