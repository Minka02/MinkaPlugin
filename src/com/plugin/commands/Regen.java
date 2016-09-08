package com.plugin.commands;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.Handler.Msg;

public class Regen extends CoderCommand
{
  public Regen(String name)
  {
    super(name);
    description = "macht regen au oder aus";
    usageMessage = ("/" + name);
    setPermission("minka.regen");
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;
    if ((hasPermission(sender)) || (sender.isOp()))
    {
      World world = sender.getLocation().getWorld();
      if (world.hasStorm()) {
        msg(sender, Msg.getMSG("cc.regen.aus"));
        world.setStorm(false);
        return true;
      }
      world.setStorm(true);
      msg(sender, Msg.getMSG("cc.regen.an"));
      return true;
    }

    return false;
  }
}