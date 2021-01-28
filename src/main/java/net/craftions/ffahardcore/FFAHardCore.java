package net.craftions.ffahardcore;

import net.craftions.ffahardcore.commands.CommandAdmin;
import net.craftions.ffahardcore.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class FFAHardCore extends JavaPlugin {

    public static FFAHardCore plugin;
    public static Config config;
    public static LocationManager locationManager = new LocationManager();
    public static String prefix = "[§cHardCore§r] ";

    @Override
    public void onEnable() {
        plugin = this;
        config = new Config(new File("./plugins/FFAHardCore/config.yml"));
        getCommand("admin").setExecutor(new CommandAdmin());
        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerInventory(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerItemDrop(), this);
        Bukkit.getPluginManager().registerEvents(new EventFoodLevelChange(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
