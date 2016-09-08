package com.plugin.Handler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import com.coder.client.main.YmlFile;

public class InvListner implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player)e.getWhoClicked();
			if(e.getInventory().getName().equals(MyInventory.commandInv(p).getName())) {
				e.setCancelled(true);
				int slot = e.getSlot();
				boolean canExe = false;
				ItemMeta slotMeta = e.getInventory().getItem(slot).getItemMeta();
				if(!slotMeta.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&c&lNO PERMISSION"))) {
					canExe = true;
				}
				if(canExe) {
					if(!YmlFile.loadConfig("config.yml").getBoolean("Prefix")) {
						switch(slot) {
							case 0:
								p.performCommand("tag");
								p.closeInventory();
								break;
							case 1:
								p.performCommand("nacht");
								p.closeInventory();
								break;
							case 2:
								p.performCommand("regen");
								p.closeInventory();
								break;
							case 3:
								p.performCommand("fly");
								p.closeInventory();
								break;
							case 4:
								p.performCommand("fix");
								p.closeInventory();
								break;
							case 5:
								MyInventory.changeGMItem(p);
								p.closeInventory();
								break;
						}
					} else {
						switch(slot) {
							case 0:
								p.performCommand("mtag");
								p.closeInventory();
								break;
							case 1:
								p.performCommand("mnacht");
								p.closeInventory();
								break;
							case 2:
								p.performCommand("mregen");
								p.closeInventory();
								break;
							case 3:
								p.performCommand("mfly");
								p.closeInventory();
								break;
							case 4:
								p.performCommand("mfix");
								p.closeInventory();
								break;
							case 5:
								MyInventory.changeGMItem(p);
								p.closeInventory();
								break;
						}
					}
				}
			}
		}
	}

}
