package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.Handler.Msg;

public class Nacht extends CoderCommand
{
  public Nacht(String name)
  {
    super(name);
    description = "Macht Nacht";
    usageMessage = ("/" + name);
    setPermission("minka.nacht");
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;
    if ((hasPermission(sender)) || (sender.isOp()))
    {
      sender.getWorld().setTime(160000L);
      msg(sender, Msg.getMSG("cc.nacht"));
      return true;
    }

    return false;
  }
}