package com.plugin.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.plugin.Handler.Msg;

public class Tag extends CoderCommand
{
  public Tag(String name)
  {
    super(name);
    description = "Macht Tag";
    usageMessage = ("/" + name);
    setPermission("minka.tag");
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;
    if ((hasPermission(sender)) || (sender.isOp()))
    {
      sender.getWorld().setTime(1000L);
      msg(sender, Msg.getMSG("cc.tag"));
      return true;
    }

    return false;
  }
}