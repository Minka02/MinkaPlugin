package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.load.PluginLoader;

public class Info_ingame extends CoderCommand {
	public Info_ingame(String name) {
		super(name);
		description = "Zeigt infos über das plugin";
		usageMessage = ("/"+name);
		setPermission("minka.info_ingame");
	}

	public boolean onCmd(CommandSender arg0, String[] args) {
		Player sender = (Player)arg0;
		if((hasPermission(sender)||sender.isOp())&&args.length==0) {
			sender.sendMessage(PluginLoader.color("&aSeite 0/4"));
			sender.sendMessage(PluginLoader.color("&aName: MinkaPrivat"));
			sender.sendMessage(PluginLoader.color("&aVersion: 1.1"));
			sender.sendMessage(PluginLoader.color("&aAutor: Minka_H"));

			return true;
		}
		if(((hasPermission(sender))||(sender.isOp()))&&(args.length==1)) {
			if(args[0].equals("1")) {
				sender.sendMessage(PluginLoader.color("&aSeite 1/3"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aMan kann das <m> vor dem Befell Ein und Aus schalten!!"));
				sender.sendMessage(PluginLoader.color("&b/<m>tell <Playername> <Nachricht>"));
				sender.sendMessage(PluginLoader.color("&b/<m>inv"));
				sender.sendMessage(PluginLoader.color("&b/<m>invsee <Playername>"));
				sender.sendMessage(PluginLoader.color("&b/<m>fix <Playername>"));
				sender.sendMessage(PluginLoader.color("&b/<m>fly <Playername>"));
				sender.sendMessage(PluginLoader.color("&b/<m>gm <0,1,2,3>"));
				sender.sendMessage(PluginLoader.color("&b/<m>nacht"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aBitte einfach Testen ob mit oder ohne <m> geht!!"));

				return true;
			}
			if(args[0].equals("2")) {
				sender.sendMessage(PluginLoader.color("&aSeite 2/3"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aMan kann das <m> vor dem Befell Ein und Aus schalten!!"));
				sender.sendMessage(PluginLoader.color("&b/<m>regen"));
				sender.sendMessage(PluginLoader.color("&b/<m>tag"));
				sender.sendMessage(PluginLoader.color("&b/<m>energydrink <Playername>"));
				sender.sendMessage(PluginLoader.color("&b/<m>drogen <Playername>"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aBitte einfach Testen ob mit oder ohne <m> geht!!"));
				return true;
			}
			if(args[0].equals("3")) {
				sender.sendMessage(PluginLoader.color("&aSeite 3/3"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aMan kann das <m> vor dem Befell Ein und Aus schalten!!"));
				sender.sendMessage(PluginLoader.color("&c[Achtung] &aBitte einfach Testen ob mit oder ohne <m> geht!!"));
				return true;
			}

		}

		return false;
	}
}