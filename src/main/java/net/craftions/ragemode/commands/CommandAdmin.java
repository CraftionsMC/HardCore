/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ragemode.commands;

import net.craftions.ragemode.Ragemode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdmin implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                sender.sendMessage(Ragemode.prefix + "§cWrong usage! Type §e/help admin §cfor help.");
            }else {
                if(args[0].equals("setspawn")){
                    Ragemode.locationManager.setLocation("spawn", ((Player) sender).getLocation());
                    Ragemode.config.getConfig().set("ragemode.spawn", ((Player) sender).getLocation());
                    Ragemode.config.reloadConfig(true);
                    sender.sendMessage(Ragemode.prefix + "§aThe spawn was successfully set.");
                }else if(args[0].equals("tpspawn")){
                    if(Ragemode.locationManager.hasLocation("spawn")) {
                        ((Player) sender).teleport(Ragemode.locationManager.getLocation("spawn"));
                    }else {
                        sender.sendMessage(Ragemode.prefix + "§cThe spawn has not been defined yet! Type §e/admin setspawn §cto fix this.");
                    }
                }else {
                    sender.sendMessage(Ragemode.prefix + "§cWrong usage! Type §e/help admin §cfor help.");
                }
            }
        }else {
            sender.sendMessage(Ragemode.prefix + "§cYou need to be a player.");
        }
        return true;
    }
}
