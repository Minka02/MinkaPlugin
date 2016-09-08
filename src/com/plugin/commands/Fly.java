package com.plugin.commands;

import com.coder.client.main.CoderCommand;
import com.plugin.load.PluginLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly extends CoderCommand
{
  public Fly(String name)
  {
    super(name);
    description = "kanst fligen";
    usageMessage = ("/" + name);
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;

    if ((args.length < 1) && (
      (sender.hasPermission("minka.fly.self")) || (sender.isOp()))) {
      if (sender.getAllowFlight()) {
        sender.setFlying(false);
        sender.setAllowFlight(false);
        msg(sender, "&bDu kannst nicht mehr Fligen!");
        return true;
      }

      sender.setAllowFlight(true);
      msg(sender, "&bDu kannst jetzt Fligen!");
      return true;
    }

    if ((args.length == 1) && 
      (isOnline(args[0])) && (
      (sender.hasPermission("minka.fly.other")) || (sender.isOp()))) {
      Player p = getOnlinePlayer(args[0]);
      if (p.getAllowFlight()) {
        p.setFlying(false);
        p.setAllowFlight(false);
        sender.sendMessage(PluginLoader.color("&bDer spiler &9" + p.getName() + " &bkann nicht mehr Fligen!"));
        p.sendMessage(PluginLoader.color("&bDer Spieler &9" + sender.getName() + " &bhat dir das Fligen Enzogen!"));
        return true;
      }
      p.setAllowFlight(true);
      sender.sendMessage(PluginLoader.color("&bDer Spiler &9" + p.getName() + " &bkann jetzt Fligen!"));
      p.sendMessage(PluginLoader.color("&bDer Spiler &9" + sender.getName() + " &bhat dir das Fligen Ermöglicht!"));
      return true;
    }

    return false;
  }
}