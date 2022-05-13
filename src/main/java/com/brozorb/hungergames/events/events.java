package com.brozorb.hungergames.events;

import com.brozorb.hungergames.Hungergames;
import com.brozorb.hungergames.inventories.teamSelect;
import com.hiddentech.playerstorage.PlayerStorageAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static java.lang.String.valueOf;
import static org.bukkit.Bukkit.getServer;


public class events implements Listener {

    @EventHandler
    public static void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GREEN + "Welcome to the Hunger Games!");
    }




    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof teamSelect) {

            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked(); //get the player who clicked
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                // set the player's team to red
                player.setPlayerListName(ChatColor.RED + player.getName());
                player.sendMessage(ChatColor.RED + "You are now on the Red Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "red");

            } else if (e.getCurrentItem().getType() == Material.ORANGE_STAINED_GLASS_PANE) {
                // set the player's team to orange
                player.setPlayerListName(ChatColor.GOLD + player.getName());
                player.sendMessage(ChatColor.GOLD + "You are now on the Orange Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "orange");

            } else if (e.getCurrentItem().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                // set the player's team to yellow
                player.setPlayerListName(ChatColor.YELLOW + player.getName());
                player.sendMessage(ChatColor.YELLOW + "You are now on the Yellow Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "yellow");

            } else if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                // set the player's team to green
                player.setPlayerListName(ChatColor.GREEN + player.getName());
                player.sendMessage(ChatColor.GREEN + "You are now on the Green Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "lime");

            } else if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                // set the player's team to dark green
                player.setPlayerListName(ChatColor.DARK_GREEN + player.getName());
                player.sendMessage(ChatColor.DARK_GREEN + "You are now on the Dark Green Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "dark_green");

            } else if (e.getCurrentItem().getType() == Material.BLUE_STAINED_GLASS_PANE) {
                // set the player's team to blue
                player.setPlayerListName(ChatColor.BLUE + player.getName());
                player.sendMessage(ChatColor.BLUE + "You are now on the Blue Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "blue");

            } else if (e.getCurrentItem().getType() == Material.LIGHT_BLUE_STAINED_GLASS_PANE) {
                // set the player's team to light blue
                player.setPlayerListName(ChatColor.DARK_AQUA + player.getName());
                player.sendMessage(ChatColor.DARK_AQUA + "You are now on the Light Blue Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "light_blue");

            } else if (e.getCurrentItem().getType() == Material.PURPLE_STAINED_GLASS_PANE) {
                // set the player's team to purple
                player.setPlayerListName(ChatColor.DARK_PURPLE + player.getName());
                player.sendMessage(ChatColor.DARK_PURPLE + "You are now on the Purple Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "purple");

            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                // set the player's team to spectator
                player.setPlayerListName(ChatColor.GRAY + player.getName());
                player.sendMessage(ChatColor.GRAY + "You are now on the Spectator Team!");
                Hungergames.playerStorageAPI.set(player.getUniqueId(), "team", "spectator");

            }

            // close the inventory
            player.closeInventory();
        }

    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        //cancel the attack if the entity hit is the same team as the attacker.
        Player attacker = (Player) event.getDamager();
        Entity victim = event.getEntity();
        //getServer().getConsoleSender().sendMessage(ChatColor.GOLD + attacker.getName());
        //getServer().getConsoleSender().sendMessage(ChatColor.GOLD + victim.getName());
        if (victim instanceof Player) {
            if (Hungergames.playerStorageAPI.getString(attacker.getUniqueId(), "team").equals(Hungergames.playerStorageAPI.getString(victim.getUniqueId(), "team"))) {
                // the victim is always on the same team as the attacker?
                //event.setCancelled(true);
                attacker.sendMessage(ChatColor.RED+"Don't attack your team!");
                victim.sendMessage(ChatColor.GREEN+"Damage Dealt by your team mate " + attacker.getName() + " was stopped");
            }
        }
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (Hungergames.starting == true) {
            event.setCancelled(true);
        }
    }

}

