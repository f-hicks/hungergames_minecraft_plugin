package com.brozorb.hungergames.events;

import com.brozorb.hungergames.Hungergames;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class onDeath implements Listener {



    public static void onEnd(Player p, PlayerDeathEvent event) {
        World world = p.getWorld();
        WorldBorder worldBorder = world.getWorldBorder();
        worldBorder.setCenter(-165, -214);
        worldBorder.setSize(50);
        world.setSpawnLocation(-165,153,-214,-90);
        Location location = new Location(world,-165,153,-214,-90,0);
        for (Player PlayersOnline : p.getWorld().getPlayers()) {
            PlayersOnline.teleport(location);
            PlayersOnline.setGameMode(GameMode.ADVENTURE);
        }

    }

    @EventHandler
    public static void onDeath(PlayerDeathEvent event){

        if (event.getPlayer().getKiller() == null) {
            return;
        }

        Player killer = event.getPlayer().getKiller();
        Player victim = event.getPlayer();
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "The killer is: "+killer.getName());
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "The victim is: "+victim.getName());
        Hungergames.PlayersPlaying.remove(victim);
        boolean sameTeam = true;
        for (Player p : Hungergames.PlayersPlaying) {
            if (p == Hungergames.PlayersPlaying.get(0)){
                break;
            } else {
                if (Objects.equals(Hungergames.playerStorageAPI.getString(p.getUniqueId(), "team"), Hungergames.playerStorageAPI.getString(Hungergames.PlayersPlaying.get(Hungergames.PlayersPlaying.indexOf(p) - 1).getUniqueId(), "team"))){
                    break;

                } else {
                    sameTeam = false;
                }
            }


        }

        event.setCancelled(true);
        Location location = new Location(victim.getWorld(), 0,100,0,0,90);
        victim.teleport(location);
        victim.setGameMode(GameMode.SPECTATOR);

        if (sameTeam) {
            onEnd(Hungergames.PlayersPlaying.get(0),event);
        }
    }
}
