package com.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;

public class Invsee extends CoderCommand {

	public Invsee(String name) {
		super(name);
		description = "Ins Inv schuen";
		usageMessage = "/invsee"+name;
		setPermission("minka.invsee");
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		Player p = (Player)arg0;
		if(hasPermission(p) || p.isOp()) {
			if(args.length==1) {
				
				Player p2 = Bukkit.getPlayer(args[0]);

				p.openInventory(p2.getInventory());

				msg(p, " &bInvsee wurde bei "+p2.getName()+" ausgefürt! ");
			}

		} else{
			msg(p, p.getName() + "&4Du hast Keine rechte für Invsee");
			
		}
		return false;
	}

}
