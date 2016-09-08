package com.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.coder.client.main.CoderCommand;
import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class Wartung extends CoderCommand implements Listener {

	public Wartung(String name) {
		super(name);
		description = "Wartungsmodus";
		usageMessage = "/";
		setPermission("minka.wartung");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player p = (Player)arg0;
		if(hasPermission(p)||p.isOp()) {

			if(!YmlFile.loadConfig("config.yml").getBoolean("Status")) {
				// false
				YmlFile.loadConfig("config.yml").set("Status", true);
				YmlFile.save();
				Bukkit.broadcastMessage(PluginLoader.color("&cDer Wartungsmodus wurde &aAktiviert!"));

				for(Player a : Bukkit.getServer().getOnlinePlayers()) {
					if(!(a.hasPermission("wartung.nokick")||a.isOp())) {

						a.kickPlayer(PluginLoader.color("&cDer Wartungsmodus wurde &aAktiviert!"));
					}

				}
				return true;

			} else {
				// ture
				YmlFile.loadConfig("config.yml").set("Status", false);
				YmlFile.save();
				Bukkit.broadcastMessage(PluginLoader.color("&cDer Wartungsmodus wurde &aDeaktevirt!"));

			}

		}
		return false;
	}

	@EventHandler
	public void on(PlayerLoginEvent e) {
		Player p = e.getPlayer();

		if(YmlFile.loadConfig("config.yml").getBoolean("Status")) {
			// true
			if(!(p.hasPermission("wartung.nokick")||p.isOp())) {
				e.disallow(Result.KICK_OTHER, PluginLoader.color("&cDer Wartungsmodus wurde &aaktiviert! \n "+" &cVersuche es Später erneut!"));
			}
		}
	}

}
