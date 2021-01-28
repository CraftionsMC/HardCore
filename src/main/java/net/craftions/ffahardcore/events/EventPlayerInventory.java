/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ffahardcore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventPlayerInventory implements Listener {

    @EventHandler
    public void onInventoryItemClick(InventoryClickEvent e){
        if(!e.getWhoClicked().hasPermission("craftions.ragemode.inventory.bypass")){
            e.setCancelled(true);
        }
    }
}
