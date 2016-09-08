package com.plugin.commands;

import java.util.Arrays;
import java.util.stream.Collectors;

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
				Player p2 = getOnlinePlayer(args[1]);
				if(p2 != null) {
					message = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0], "");
					message = message.replace(args[1], "");
					p.sendMessage("§ctell §r-> §a " + p2.getName() + " §6 " + message);
					p2.sendMessage("§c " + p.getName() + " §r-> §ctell §6>> " + message);
					message = "";
					return true;
				} else {
					p.sendMessage("§b Spieler ist nicht online!");
					return true;
				}

			}
		
		return false;
	}

}