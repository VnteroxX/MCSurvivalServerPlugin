package me.luciid.survivalserver;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String norights = "§cDigger du Weib hast KEINE RECHTE dafür HAHAHA opfer lol";
        String nogamemode = "§cBist du behindert? Es gibt nur Gamemodes §b0, 1, 2, 3";
        String noargs = "§cDa hat wohl eine Mongo gefettfingert";
        String changeme = "§aDu bist jetzt im §6";
        String changeyou = "§a ist jetzt im §6";
        String noplayer1 = "§cDu vollspasst, der Spieler §6";
        String noplayer2 = " §cist garnicht online";

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("luciid.gm")) {
                if (args.length == 1) {
                    if(args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(changeme + "Survivalmodus");
                    } else if (args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(changeme + "Kreativmodus");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(changeme + "Opfermodus");
                    } else if (args[0].equalsIgnoreCase("3")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(changeme + "Zuschauermodus");
                    } else {
                        player.sendMessage(nogamemode);
                    }
                } else if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if(target != null) {
                        if(args[0].equalsIgnoreCase("0")) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(changeme + "Survivalmodus");
                            player.sendMessage("§3"+target.getName()+changeyou+"Survivalmodus");
                        } else if (args[0].equalsIgnoreCase("1")) {
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(changeme + "Kreativmodus");
                            player.sendMessage("§3"+target.getName()+changeyou+"Kreativmodus");
                        } else if (args[0].equalsIgnoreCase("2")) {
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(changeme + "Opfermodus");
                            player.sendMessage("§3"+target.getName()+changeyou+"Opfermodus");
                        } else if (args[0].equalsIgnoreCase("3")) {
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(changeme + "Zuschauermodus");
                            player.sendMessage("§3"+target.getName()+changeyou+"Zuschauermodus");
                        } else {
                            player.sendMessage(nogamemode);
                        }
                    } else {
                        player.sendMessage(noplayer1 + args[1] + noplayer2);
                    }
                } else {
                    player.sendMessage(noargs);
                }
            } else {
                player.sendMessage(norights);
            }
        }
        return false;
    }
}
