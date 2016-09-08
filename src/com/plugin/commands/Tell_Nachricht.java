package com.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;

public class Tell_Nachricht extends CoderCommand {

	String message = "";

	public Tell_Nachricht(String name) {

		super(name);
		description = "Private MSG";
		usageMessage = ("/"+name);
		setPermission("");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player p = (Player)arg0;
			if(args.length >= 2) {
				Player p2 = Bukkit.getPlayer(args[0]);

				if(p2 != null) {
					for(int i = 1; i < args.length; i++) {
						message = message + args[i]+ " ";
					}
					p.sendMessage("§ctell §r-> §a " + p2.getName() + " §6 " + message);
					p2.sendMessage("§c " + p.getName() + " §r-> §ctell §6>> " + message);
					message = " ";

				} else {
					p.sendMessage("§b Spieler ist nicht online!");
				}

			}
		
		return false;
	}

}