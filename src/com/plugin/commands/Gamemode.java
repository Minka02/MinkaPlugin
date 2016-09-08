package com.plugin.commands;

import com.coder.client.main.CoderCommand;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode extends CoderCommand {
	public Gamemode(String name) {
		super(name);
		description = "Ändert Dein Spielmodus";
		usageMessage = ("/"+name);
		setPermission("");
	}

	public boolean onCmd(CommandSender arg0, String[] args) {
		Player sender = (Player)arg0;
		if(((sender.hasPermission("minka.gm.self"))||(sender.isOp()))&&(args.length==1)) {
			if(args[0].equals("0")) {
				sender.setGameMode(GameMode.SURVIVAL);
				msg(sender, "&bDu bist jezt im SURVIVAL modus");
				return true;
			}
			if(args[0].equals("1")) {
				sender.setGameMode(GameMode.CREATIVE);
				msg(sender, "&bDu bist jezt im CREATIVE modus");
				return true;
			}
			if(args[0].equals("2")) {
				sender.setGameMode(GameMode.ADVENTURE);
				msg(sender, "&bDu bist jezt im ADVENTURE modus");

				return true;
			}
			if(args[0].equals("3")) {
				sender.setGameMode(GameMode.SPECTATOR);
				msg(sender, "&bDu bist jezt im SPECTATOR modus");
				return true;
			}

		}

		if((args.length==2)&&(isOnline(args[0]))&&((sender.hasPermission("minka.gm.other"))||(sender.isOp()))) {

			Player p = getOnlinePlayer(args[0]);

			if(args[1].equals("0")) {
				p.setGameMode(GameMode.SURVIVAL);
				msg(p, "&bDu bist jezt im SURVIVAL modus");
				return true;
			}
			if(args[1].equals("1")) {
				p.setGameMode(GameMode.CREATIVE);
				msg(p, "&bDu bist jezt im CREATIVE modus");
				return true;
			}
			if(args[1].equals("2")) {
				p.setGameMode(GameMode.ADVENTURE);
				msg(p, "&bDu bist jezt im ADVENTURE modus");

				return true;
			}
			if(args[1].equals("3")) {
				p.setGameMode(GameMode.SPECTATOR);
				msg(p, "&bDu bist jezt im SPECTATOR modus");
				return true;
			}

		}

		return false;
	}
}