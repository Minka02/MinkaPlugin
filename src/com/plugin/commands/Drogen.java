package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.coder.client.main.CoderCommand;
import com.coder.client.main.YmlFile;
import com.plugin.load.PluginLoader;

public class Drogen extends CoderCommand {
	public Drogen(String name) {
		super(name);
		description = "gibt dir drogen";
		usageMessage = ("/"+name);
	}

	public boolean onCmd(CommandSender arg0, String[] args) {
		Player sender = (Player)arg0;
		if((sender.hasPermission("minka.drogen.self"))&&(args.length<1)) {
			sender.setHealth(20);
			sender.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 7200, 6));
			sender.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 7200, 6));
			sender.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 7200, 50));

			sender.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 3600, 6));
			sender.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 7200, 5));
			sender.sendMessage(PluginLoader.color("&bDu bist auf Droge"));
			return true;
		}

		if((args.length==1)&&(isOnline(args[0]))&&(sender.hasPermission("minka.drogen.other"))) {
			Player p = getOnlinePlayer(args[0]);
			sender.setHealth(20);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 7200, 6));
			p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 7200, 6));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 7200, 50));

			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 3600, 6));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 7200, 6));

			sender.sendMessage(PluginLoader.color(YmlFile.loadConfig("messages.yml").getString("cc.test").replace("%player%", p.getName())));
			p.sendMessage(PluginLoader.color("&bDer Spieler &9"+sender.getName()+" &bhat dir Drogen gegeben"));
			return true;
		}

		return false;
	}
}