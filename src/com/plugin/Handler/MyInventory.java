package com.plugin.Handler;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.coder.client.main.YmlFile;

public class MyInventory {

	public static Inventory commandInv(Player p) {
		Inventory inv = Bukkit.getServer().createInventory(null, 9, "Commands");

		ItemStack np = new ItemStack(Material.WOOL, 1, (short)14);
		ItemMeta imnp = np.getItemMeta();
		imnp.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lNO PERMISSION"));
		np.setItemMeta(imnp);

		{
			ItemStack is = new ItemStack(Material.GOLD_BLOCK);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lMake it Day"));
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6You dont Like the Night?"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6So use the Gold to make light!"));
			im.setLore(lore);
			is.setItemMeta(im);
			if(p.hasPermission("minka.tag")) {
				inv.setItem(0, is);
			} else {
				inv.setItem(0, np);
			}
		}
		{
			ItemStack is = new ItemStack(Material.OBSIDIAN);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lMake it Night"));
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6You dont Like the Day?"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6So use the Obsidian to make it Grey!"));
			im.setLore(lore);
			is.setItemMeta(im);
			if(p.hasPermission("minka.nacht")) {
				inv.setItem(1, is);
			} else {
				inv.setItem(1, np);
			}
		}
		{
			ItemStack is = new ItemStack(Material.WATER_BUCKET);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lMake it Rain"));
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6You dont Like the Dry?"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6So use the Bucket to make Water fly!"));
			im.setLore(lore);
			is.setItemMeta(im);
			if(p.hasPermission("minka.regen")) {
				inv.setItem(2, is);
			} else {
				inv.setItem(2, np);
			}
		}
		{
			ItemStack is = new ItemStack(Material.FEATHER);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lTakeoff"));
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6You dont Like to Walk?"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6So use the Feather to glide along!"));
			im.setLore(lore);
			is.setItemMeta(im);
			if(p.hasPermission("minka.fly.self")) {
				inv.setItem(3, is);
			} else {
				inv.setItem(3, np);
			}
		}
		{
			ItemStack is = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lHeal yourself"));
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6You dont Like Death?"));
			lore.add(ChatColor.translateAlternateColorCodes('&', "&6So use the Golden Appel to heal yourself!"));
			im.setLore(lore);
			is.setItemMeta(im);
			if(p.hasPermission("minka.fix.self")) {
				inv.setItem(4, is);
			} else {
				inv.setItem(4, np);
			}
		}
		{
			switch(p.getGameMode()) {
				case SURVIVAL:
					if(p.hasPermission("minka.gm.self")) {
						inv.setItem(5, survivalItem());
					} else nopM(np, inv);
					break;
				case CREATIVE:
					if(p.hasPermission("minka.gm.self")) {
						inv.setItem(5, creativeItem());
					} else nopM(np, inv);
					break;
				case SPECTATOR:
					if(p.hasPermission("minka.gm.self")) {
						inv.setItem(5, spectatorItem());
					} else nopM(np, inv);
					break;
				default:
					if(p.hasPermission("minka.gm.self")) {
						inv.setItem(5, survivalItem());
					} else nopM(np, inv);
					break;
			}
		}
		return inv;
	}

	private static void nopM(ItemStack is, Inventory inv) {
		inv.setItem(5, is);
	}

	@SuppressWarnings("deprecation")
	public static void changeGMItem(Player p) {
		ItemStack is = commandInv(p).getItem(5);
		ItemMeta im = is.getItemMeta();
		if(!im.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&c&lNO PERMISSION"))) {
			if(!YmlFile.loadConfig("config.yml").getBoolean("Prefix")) {
				if(is.getAmount()==1) {
					commandInv(p).setItem(5, creativeItem());
					p.updateInventory();
					p.performCommand("gm 1");
				}
				if(is.getAmount()==2) {
					commandInv(p).setItem(5, spectatorItem());
					p.updateInventory();
					p.performCommand("gm 3");
				}
				if(is.getAmount()==3) {
					commandInv(p).setItem(5, survivalItem());
					p.updateInventory();
					p.performCommand("gm 0");
				}
			} else {
				if(is.getAmount()==1) {
					commandInv(p).setItem(5, creativeItem());
					p.updateInventory();
					p.performCommand("mgm 1");
				}
				if(is.getAmount()==2) {
					commandInv(p).setItem(5, spectatorItem());
					p.updateInventory();
					p.performCommand("mgm 3");
				}
				if(is.getAmount()==3) {
					commandInv(p).setItem(5, survivalItem());
					p.updateInventory();
					p.performCommand("mgm 0");
				}
			}
		}
	}

	private static ItemStack survivalItem() {
		ItemStack is = new ItemStack(Material.DIRT);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSurvival"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Classic Minecraft"));
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

	private static ItemStack creativeItem() {
		ItemStack is = new ItemStack(Material.DIAMOND_PICKAXE, 2);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCreative"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Build what you want"));
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

	private static ItemStack spectatorItem() {
		ItemStack is = new ItemStack(Material.NETHER_STAR, 3);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSpectator"));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', "&6Watch others!"));
		im.setLore(lore);
		is.setItemMeta(im);
		return is;
	}

}
