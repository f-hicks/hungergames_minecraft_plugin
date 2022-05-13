package com.brozorb.hungergames;

import com.brozorb.hungergames.commands.commands;
import com.brozorb.hungergames.commands.start;
import com.brozorb.hungergames.events.events;
import com.brozorb.hungergames.events.onDeath;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.hiddentech.playerstorage.PlayerStorageAPI;

import java.util.ArrayList;
import java.util.List;


public final class Hungergames extends JavaPlugin {

    public static PlayerStorageAPI playerStorageAPI;
    public static Boolean starting;
    public static Hungergames plugin;
    public static Boolean inGame;
    public static ArrayList<Player> PlayersPlaying = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        commands commands = new commands();
        start start = new start();
        this.playerStorageAPI = PlayerStorageAPI.getInstance(this);
        this.starting = false;
        this.inGame = false;


        plugin = this;

        playerStorageAPI.registerValue("team","spectator");
        playerStorageAPI.registerValue("kills","0");
        playerStorageAPI.registerValue("deaths","0");
        playerStorageAPI.registerValue("wins","0");
        playerStorageAPI.registerValue("losses","0");
        playerStorageAPI.registerValue("gamesplayed","0");

        getServer().getPluginManager().registerEvents(new events(), this);
        getServer().getPluginManager().registerEvents(new onDeath(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("team").setExecutor(commands);
        getCommand("start").setExecutor(start);
        //tell the console that the plugin has been enabled
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Hungergames] Hungergames has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //tell the console that the plugin has been disabled
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Hungergames]: Hungergames has been disabled!");
    }
}
