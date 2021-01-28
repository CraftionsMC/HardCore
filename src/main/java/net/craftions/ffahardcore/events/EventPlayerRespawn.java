/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ffahardcore.events;

import net.craftions.ffahardcore.FFAHardCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventPlayerRespawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        try {
            e.getPlayer().teleport(FFAHardCore.locationManager.getLocation("spawn"));
        }catch (Exception ex){
            e.getPlayer().sendMessage(FFAHardCore.prefix + "§cThe spawn was not set yet. Please define the spawn with §e/admin setspawn");
        }
    }
}
