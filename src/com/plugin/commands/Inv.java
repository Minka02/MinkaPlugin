package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.Handler.MyInventory;

public class Inv extends CoderCommand {

	public Inv(String name) {
		super(name);
		description = "Beispiels Inventar";
		usageMessage = "/";
		setPermission("minka.inv");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player p = senderToPlayer(arg0);
		if(hasPermission(p)) {

			p.openInventory(MyInventory.commandInv(p));

		}
		return true;
	}

}
