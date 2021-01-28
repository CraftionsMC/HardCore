/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ragemode.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class EventPlayerItemDrop implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(!e.getPlayer().hasPermission("craftions.ragemode.bypass")){
            e.setCancelled(true);
        }
    }
}
