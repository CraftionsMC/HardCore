/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ffahardcore.commands;

import net.craftions.ffahardcore.FFAHardCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdmin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                sender.sendMessage(FFAHardCore.prefix + "§cWrong usage! Type §e/help admin §cfor help.");
            }else {
                if(args[0].equals("setspawn")){
                    FFAHardCore.locationManager.setLocation("spawn", ((Player) sender).getLocation());
                    FFAHardCore.config.getConfig().set("ragemode.spawn", ((Player) sender).getLocation());
                    FFAHardCore.config.reloadConfig(true);
                    sender.sendMessage(FFAHardCore.prefix + "§aThe spawn was successfully set.");
                }else if(args[0].equals("tpspawn")){
                    if(FFAHardCore.locationManager.hasLocation("spawn")) {
                        ((Player) sender).teleport(FFAHardCore.locationManager.getLocation("spawn"));
                    }else {
                        sender.sendMessage(FFAHardCore.prefix + "§cThe spawn has not been defined yet! Type §e/admin setspawn §cto fix this.");
                    }
                }else {
                    sender.sendMessage(FFAHardCore.prefix + "§cWrong usage! Type §e/help admin §cfor help.");
                }
            }
        }else {
            sender.sendMessage(FFAHardCore.prefix + "§cYou need to be a player.");
        }
        return true;
    }
}
