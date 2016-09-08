package com.plugin.load;

import org.bukkit.ChatColor;

import com.coder.client.main.PluginRegistry;
import com.coder.client.main.YmlFile;
import com.plugin.Handler.InvListner;
import com.plugin.Handler.MessageHandler;
import com.plugin.Handler.Msg;
import com.plugin.commands.Drogen;
import com.plugin.commands.EnergyDrimk;
import com.plugin.commands.Fix;
import com.plugin.commands.Fly;
import com.plugin.commands.Gamemode;
import com.plugin.commands.Info_ingame;
import com.plugin.commands.Inv;
import com.plugin.commands.Invsee;
import com.plugin.commands.Nacht;
import com.plugin.commands.Regen;
import com.plugin.commands.Tag;
import com.plugin.commands.Tell_Nachricht;
import com.plugin.commands.Wartung;

public class PluginLoader {
	public void loadPlugin() {
		new Config().cfgGen();
		new Msg();

		PluginRegistry.registerListener(new MessageHandler());
		PluginRegistry.registerListener(new InvListner());
		PluginRegistry.registerListener(new Wartung(null));
		
		if(YmlFile.loadConfig("config.yml").getBoolean("Prefix")) {
			PluginRegistry.registerCommand("mfix", new Fix("mfix"));
			PluginRegistry.registerCommand("mgm", new Gamemode("mgm"));
			PluginRegistry.registerCommand("mnacht", new Nacht("mnacht"));
			PluginRegistry.registerCommand("mtag", new Tag("mtag"));
			PluginRegistry.registerCommand("mregen", new Regen("mregen"));
			PluginRegistry.registerCommand("mfly", new Fly("mfly"));
			PluginRegistry.registerCommand("menergydrink", new EnergyDrimk("menergydrink"));
			PluginRegistry.registerCommand("mdrogen", new Drogen("mdrogen"));
			PluginRegistry.registerCommand("mtell", new Tell_Nachricht("mtell"));
			PluginRegistry.registerCommand("minv", new Inv("minv"));
			PluginRegistry.registerCommand("minvsee", new Invsee("minvsee"));
			PluginRegistry.registerCommand("mwartung", new Wartung("mwartung"));
		} else {
			PluginRegistry.registerCommand("fix", new Fix("fix"));
			PluginRegistry.registerCommand("gm", new Gamemode("gm"));
			PluginRegistry.registerCommand("nacht", new Nacht("nacht"));
			PluginRegistry.registerCommand("tag", new Tag("tag"));
			PluginRegistry.registerCommand("regen", new Regen("regen"));
			PluginRegistry.registerCommand("fly", new Fly("fly"));
			PluginRegistry.registerCommand("menergydrink", new EnergyDrimk("menergydrink"));
			PluginRegistry.registerCommand("drogen", new Drogen("drogen"));
			PluginRegistry.registerCommand("tell", new Tell_Nachricht("tell"));
			PluginRegistry.registerCommand("inv", new Inv("inv"));
			PluginRegistry.registerCommand("invsee", new Invsee("invsee"));
			PluginRegistry.registerCommand("wartung", new Wartung("wartung"));
		}

		PluginRegistry.registerCommand("info", new Info_ingame("info"));
	}

	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
}