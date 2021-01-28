package net.craftions.ragemode;

import net.craftions.ragemode.commands.CommandAdmin;
import net.craftions.ragemode.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Ragemode extends JavaPlugin {

    public static Ragemode plugin;
    public static Config config;
    public static LocationManager locationManager = new LocationManager();
    public static String prefix = "[§cRageMode§r] ";

    @Override
    public void onEnable() {
        plugin = this;
        config = new Config(new File("./plugins/RageMode/config.yml"));
        getCommand("admin").setExecutor(new CommandAdmin());
        Bukkit.getPluginManager().registerEvents(new EventPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerDeath(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerRespawn(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerInventory(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerItemDrop(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
