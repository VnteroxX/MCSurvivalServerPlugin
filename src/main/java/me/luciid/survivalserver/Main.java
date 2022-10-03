package me.luciid.survivalserver;


import me.luciid.survivalserver.backpack.BackpackCommand;
import me.luciid.survivalserver.backpack.BackpackListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.luciid.survivalserver.GamemodeCommands;

public final class Main extends JavaPlugin {

    //pimmelkopf

    @Override
    public void onLoad() {
        Main instance = this;
    }


    public void onEnable() {
        getCommand("gm").setExecutor(new GamemodeCommands());
        getCommand("backpack").setExecutor(new BackpackCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ConnectionListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new BackpackListener(), this);

        System.out.println("LuciidPlugin Schallert jetzt durch alter");

    }


    @Override
    public void onDisable() {
    }
}
