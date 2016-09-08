package com.coder.client.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.event.Listener;

public class Class_14_57648_e {
	
	public static HashMap<String, CoderCommand> f_14_57648_c;
	public static ArrayList<Listener> f_14_57648_d;
	
	public Class_14_57648_e() {
		f_14_57648_c = new HashMap<String, CoderCommand>();
		f_14_57648_d = new ArrayList<Listener>();
	}
	
	public static void m_14_57648_a(Listener listener) {
		f_14_57648_d.add(listener);
	}
	
	public static void m_14_57648_b(String cmd, CoderCommand commandClass) {
		f_14_57648_c.put(cmd, commandClass);
	}
	
}
