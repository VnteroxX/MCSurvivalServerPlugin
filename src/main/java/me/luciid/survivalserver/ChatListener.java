package me.luciid.survivalserver;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        event.setFormat("§6" + "%1$s: " + "§7" + "%2$s");

        event.getMessage();
        event.getFormat();
        event.getRecipients();
    }

}
