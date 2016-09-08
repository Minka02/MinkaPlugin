package com.coder.client.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.plugin.load.PluginLoader;

public class Coder extends JavaPlugin {

	@Override
	public void onEnable() {
		new Class_14_57648_e();
		PluginLoader pl = new PluginLoader();
		pl.loadPlugin();
		PluginManager l_15_54694 = Bukkit.getServer().getPluginManager();
		for(int i = 0; i<Class_14_57648_e.f_14_57648_d.size(); i++) {
			l_15_54694.registerEvents(Class_14_57648_e.f_14_57648_d.get(i), this);
		}
		for(String l_15_55694 : Class_14_57648_e.f_14_57648_c.keySet()) {
			Class_14_56784_d.m_14_56784(l_15_55694, Class_14_57648_e.f_14_57648_c.get(l_15_55694));
		}
	}
	
	@Override
	public void onDisable() {}
	
}
