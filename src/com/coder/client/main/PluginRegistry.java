package com.coder.client.main;

import org.bukkit.event.Listener;

public class PluginRegistry {

	public static void registerListener(Listener listener) {
		Class_14_57648_e.m_14_57648_a(listener);
	}
	
	public static void registerCommand(String cmd, CoderCommand commandClass) {
		Class_14_57648_e.m_14_57648_b(cmd, commandClass);
	}
	
}
