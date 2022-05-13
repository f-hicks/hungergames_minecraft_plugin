package com.brozorb.hungergames.commands;

import com.brozorb.hungergames.Hungergames;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class start implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("start")) {
            String world = "world";
            Hungergames.PlayersPlaying = new ArrayList<>();
            for (Player p : getServer().getWorld(world).getPlayers()) {

                String team = Hungergames.playerStorageAPI.getString(p.getUniqueId(), "team");
                if (Objects.equals(team, "red")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "orange")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "yellow")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "lime")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "dark_green")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "blue")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "light_blue")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                } else if (Objects.equals(team, "purple")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
                    p.teleport(loc);
                }
                if (Objects.equals(team, "spectator")) {
                    Location loc = new Location(Bukkit.getWorld("world"), 0.5, 107, 0, 180, 90);
                    p.teleport(loc);
                }
                Hungergames.PlayersPlaying.add(p);

                if (Objects.equals(team, "spectator")){
                    p.setGameMode(GameMode.SPECTATOR);
                }

            }
            for (Player player : Hungergames.PlayersPlaying) {
                getServer().getConsoleSender().sendMessage(player.getName());
                if (!Objects.equals(Hungergames.playerStorageAPI.getString(player.getUniqueId(), "team"), "spectator")){
                    player.setGameMode(GameMode.ADVENTURE);
                }

            }

            WorldBorder worldBorder = getServer().getWorld(world).getWorldBorder();

            worldBorder.setCenter(0, 0);
            worldBorder.setSize(250);

            Bukkit.broadcastMessage(ChatColor.GOLD + "The Hunger Games are starting");
            Hungergames.starting = true;
            Hungergames.inGame = true;
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("5");
                }
            }, 0);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("4");
                }
            }, 20L * 1);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("3");
                }
            }, 20L * 2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("2");
                }
            }, 20L * 3);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage("1");
                }
            }, 20L * 4);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Hungergames.plugin, new Runnable() {
                @Override
                public void run() {
                    Hungergames.starting = false;
                    Bukkit.broadcastMessage("GO!!");
                }
            }, 20L * 5);

        }
        return true;
    }
}
