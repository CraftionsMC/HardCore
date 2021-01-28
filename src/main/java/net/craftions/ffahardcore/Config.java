/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ffahardcore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private File config;
    private FileConfiguration conf;

    public Config(File cfile){
        this.config = cfile;
        this.checkPaths();
        this.reloadConfig(false);
    }

    public void checkPaths(){
        if(!this.config.exists()){
            this.config.getParentFile().mkdirs();
            try {
                this.config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public FileConfiguration getConfig(){
        return this.conf;
    }

    public void reloadConfig(Boolean save){
        if(save){
            saveConfig();
        }
        this.conf = YamlConfiguration.loadConfiguration(this.config);
        FFAHardCore.locationManager.setLocation("spawn", this.getConfig().getLocation("hardcore.spawn"));
    }

    public void saveConfig(){
        try {
            this.conf.save(this.config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
