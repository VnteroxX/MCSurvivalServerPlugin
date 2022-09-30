package me.luciid.survivalserver;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.getDisplayName().equals("RedZenix")) {
            event.setJoinMessage("§6Der §3süße Kampf Krüppel §6schwitzt jetzt hart rein.");
        } else if(player.getDisplayName().equals("Vnterox")) {
            event.setJoinMessage("§6Die §3Geile Sau §6übertumpft jetzt alle.");
        } else {
            event.setJoinMessage("§3" + player.getName() + "§6 ist jetzt dabei.");
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(player.getDisplayName().equals("RedZenix")) {
            event.setQuitMessage("§cDer §3süße Kampf Krüppel §6geht jetzt fappen.");
        } else if(player.getDisplayName().equals("Vnterox")) {
            event.setQuitMessage("§cDie §3Geile Sau §6übertrumpft jetzt alle im RL.");
        } else {
            event.setQuitMessage("§c" + player.getName() + "§6 ist erstmal raus.");
        }
    }
}
