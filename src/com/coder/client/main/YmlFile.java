package com.coder.client.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class YmlFile {

	private static String f_15_89056_f;
	private static File f_15_89056_k;
	private static YamlConfiguration f_15_89056_r;
	
	public static void setAllPath(String name) {
		f_15_89056_f = "plugins/"+name;
	}
	
	public static void generateConfig(String name) {
		f_15_89056_k = new File(f_15_89056_f+"/"+name);
		if(!f_15_89056_k.exists()) {
			try {
				f_15_89056_k.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean configExists(String name) {
		f_15_89056_k = new File(f_15_89056_f+"/"+name);
		return f_15_89056_k.exists();
	}
	
	public static YamlConfiguration loadConfig(String name) {
		f_15_89056_r = YamlConfiguration.loadConfiguration(new File(f_15_89056_f+"/"+name));
		f_15_89056_k = new File(f_15_89056_f+"/"+name);
		return f_15_89056_r;
	}
	
	public static void save() {
		try {
			f_15_89056_r.save(f_15_89056_k);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
