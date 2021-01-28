/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ffahardcore;

import org.bukkit.Location;

import java.util.HashMap;

public class LocationManager {

    private HashMap<String, Location> locations = new HashMap<>();

    public Location getLocation(String name) {
        return locations.get(name);
    }

    public void setLocation(String name, Location loc) {
        locations.put(name, loc);
    }

    public boolean hasLocation(String name){
        return locations.containsKey(name);
    }
}
