package com.plugin.Handler;

import org.bukkit.configuration.file.YamlConfiguration;

import com.coder.client.main.YmlFile;

public class Msg {

	private static YamlConfiguration c;

	public Msg() {
		c = YmlFile.loadConfig("messages.yml");
	}

	public static String getMSG(String string) {
		return c.getString(string);

	}

}
