/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ragemode.events;

import net.craftions.ragemode.Ragemode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventPlayerRespawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        if(Ragemode.locationManager.hasLocation("spawn")){
            e.getPlayer().teleport(Ragemode.locationManager.getLocation("spawn"));
        }else {
            e.getPlayer().sendMessage(Ragemode.prefix + "§cThe spawn was not set yet. Please define the spawn with §e/admin setspawn");
        }
    }
}
