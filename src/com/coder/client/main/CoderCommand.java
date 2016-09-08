package com.coder.client.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public abstract class CoderCommand extends BukkitCommand {
	
	public CoderCommand(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender arg0, String arg1, String[] arg2) {
		if(onCmd(arg0, arg2)) {
			return true;
		} else
			return false;
	}

	public abstract boolean onCmd(CommandSender arg0, String[] args);

	public boolean hasPermission(Player player) {
		return player.hasPermission(getPermission());
	}
	
	public boolean isSenderPlayer(CommandSender sender) {
		if(sender instanceof Player) {
			return true;
		} else
			return false;
	}
	
	public Player senderToPlayer(CommandSender sender) {
		return (Player)sender;
	}
	
	@SuppressWarnings("deprecation")
	public Player getOnlinePlayer(String player) {
		return Bukkit.getServer().getPlayer(player);
	}
	
	@SuppressWarnings("deprecation")
	public OfflinePlayer getOfflinePlayer(String player) {
		return Bukkit.getServer().getOfflinePlayer(player);
	}
	
	@SuppressWarnings("deprecation")
	public boolean isOnline(String player) {
		return Bukkit.getServer().getPlayer(player).isOnline();
	}
	
	public void msg(Player player, String msg) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}
