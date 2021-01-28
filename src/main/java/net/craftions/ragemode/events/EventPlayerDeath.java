/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ragemode.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventPlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setKeepInventory(true);
        e.getDrops().clear();
    }
}
