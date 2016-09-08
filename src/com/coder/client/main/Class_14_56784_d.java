package com.coder.client.main;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

public class Class_14_56784_d {
	
	public static void m_14_56784(String cmd, BukkitCommand cmdClass) {
		try {
			final Field cmdMapF = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			cmdMapF.setAccessible(true);
			CommandMap cmdMap = (CommandMap)cmdMapF.get(Bukkit.getServer());
			cmdMap.register(cmd, cmdClass);
		} catch(NoSuchFieldException e) {
			e.printStackTrace();
		} catch(SecurityException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
