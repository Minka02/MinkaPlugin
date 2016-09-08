package com.plugin.commands;

import com.coder.client.main.CoderCommand;
import com.plugin.load.PluginLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fix extends CoderCommand
{
  public Fix(String name)
  {
    super(name);
    description = "Gibt dir Lebenskraft";
    usageMessage = ("/" + name);
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;
    if (((sender.hasPermission("minka.fix.self")) || (sender.isOp())) && 
      (args.length < 1))
    {
      sender.setHealth(20.0D);
      sender.setFireTicks(0);
      sender.setFoodLevel(20);
      sender.setFoodLevel(20);
      msg(sender, "&bDeine Lebenskraft ist zurück");
      return true;
    }

    if ((args.length == 1) && 
      (isOnline(args[0])) && (
      (sender.hasPermission("minka.energydrink.other")) || (sender.isOp()))) {
      Player p = getOnlinePlayer(args[0]);

      p.setHealth(20.0D);
      p.setFireTicks(0);
      p.setFoodLevel(20);
      p.setFoodLevel(20);
      msg(sender, "&bDeine Lebenskraft ist zurück");

      sender.sendMessage(PluginLoader.color("&bDer spiler &9" + p.getName() + " &bhat Lebenskraft bekommen!"));
      p.sendMessage(PluginLoader.color("&bDer Spieler &9" + sender.getName() + " &bhat dir Lebenskraft gegeben!"));
      return true;
    }

    return false;
  }
}