/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.ragemode.events;

import net.craftions.ragemode.Ragemode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

        ItemMeta swordMeta = sword.getItemMeta();
        ItemMeta bowMeta = bow.getItemMeta();
        ItemMeta helmetMeta = helmet.getItemMeta();
        ItemMeta chestMeta = chest.getItemMeta();
        ItemMeta leggingsMeta = leggings.getItemMeta();
        ItemMeta bootsMeta = boots.getItemMeta();

        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
        bowMeta.addEnchant(Enchantment.ARROW_FIRE, 3, true);
        helmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        leggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);

        sword.setItemMeta(swordMeta);
        bow.setItemMeta(bowMeta);
        helmet.setItemMeta(helmetMeta);
        chest.setItemMeta(chestMeta);
        leggings.setItemMeta(leggingsMeta);
        boots.setItemMeta(bootsMeta);

        e.getPlayer().getInventory().setItem(0, sword);
        e.getPlayer().getInventory().setItem(1, bow);
        e.getPlayer().getInventory().setItem(103, helmet);
        e.getPlayer().getInventory().setItem(102, chest);
        e.getPlayer().getInventory().setItem(101, leggings);
        e.getPlayer().getInventory().setItem(100, boots);

        try {
            e.getPlayer().teleport(Ragemode.locationManager.getLocation("spawn"));
        }catch (Exception ex){
            e.getPlayer().sendMessage(Ragemode.prefix + "§cThe spawn was not set yet. Please define the spawn with §e/admin setspawn");
        }
    }

}