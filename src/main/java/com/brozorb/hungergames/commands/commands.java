package com.brozorb.hungergames.commands;

import com.brozorb.hungergames.Hungergames;
import com.brozorb.hungergames.inventories.teamSelect;
import com.hiddentech.playerstorage.PlayerStorageAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.ResourceBundle;

public class commands implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //commands console / command blocks can use


        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this command!");
            return true; }
        Player player = (Player) sender;

        //commands only players can use


        // /heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.GOLD + "You have been healed!");
        }

        // /feed
        if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GOLD + "You have been fed!");

        }
        //team
        if (cmd.getName().equalsIgnoreCase("team")) {
            if (args.length == 0) {
                teamSelect gui = new teamSelect();
                player.openInventory(gui.getInventory());
                }   else {
                if (args[0].equalsIgnoreCase("red")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "red");
                    player.sendMessage(ChatColor.RED + "You are now on the Red Team!");
                } else if (args[0].equalsIgnoreCase("orange")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "orange");
                    player.sendMessage(ChatColor.GOLD + "You are now on the Orange Team!");
                } else if (args[0].equalsIgnoreCase("yellow")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "yellow");
                    player.sendMessage(ChatColor.YELLOW + "You are now on the Yellow Team!");
                } else if (args[0].equalsIgnoreCase("lime")) {

                } else if (args[0].equalsIgnoreCase("green")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "green");
                    player.sendMessage(ChatColor.DARK_GREEN + "You are now on the Green Team!");
                } else if (args[0].equalsIgnoreCase("blue")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "blue");
                    player.sendMessage(ChatColor.BLUE + "You are now on the Blue Team!");
                } else if (args[0].equalsIgnoreCase("light")) {
                    if (args[1].equalsIgnoreCase("green")) {
                        Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "light Green");
                        player.sendMessage(ChatColor.GREEN + "You are now on the Light Green Team!");
                    } else if (args[1].equalsIgnoreCase("blue")) {
                        Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "light blue");
                        player.sendMessage(ChatColor.AQUA + "You are now on the Light Blue Team!");
                    }
                } else if (args[0].equalsIgnoreCase("purple")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "purple");
                    player.sendMessage(ChatColor.DARK_PURPLE + "You are now on the Purple Team!");
                } else if (args[0].equalsIgnoreCase("spectator")) {
                    Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "spectator");
                    player.sendMessage(ChatColor.GRAY + "You are now a spectator!");
                } else {
                    player.sendMessage(ChatColor.DARK_RED + "That is not a valid team. Please try again.");
                }
                }
        //tpred
        if (cmd.getName().equalsIgnoreCase("tpred")) {
            Location loc = new Location(Bukkit.getWorld("world"), 0.5, 81, -19.5, 0, 0);
            player.teleport(loc);
        }

        }

        return true;

    }
}
