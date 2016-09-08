package com.plugin.commands;

import com.coder.client.main.CoderCommand;
import com.plugin.load.PluginLoader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnergyDrimk extends CoderCommand
{
  public EnergyDrimk(String name)
  {
    super(name);
    description = "gibt dir denn Energy Drink";
    usageMessage = ("/" + name);
  }

  public boolean onCmd(CommandSender arg0, String[] args)
  {
    Player sender = (Player)arg0;
    if (((sender.hasPermission("minka.energydrink.self")) || (sender.isOp())) && 
      (args.length < 1)) {
      sender.setHealth(20);
      sender.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 5));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 5));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 2));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000000, 5));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000000, 5));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000000000, 5));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000000, 2));
      sender.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 5));
      sender.sendMessage(PluginLoader.color("&bDu hast den Energy Drink bekommen "));
      return true;
    }

    if ((args.length == 1) && 
      (isOnline(args[0])) && (
      (sender.hasPermission("minka.energydrink.other")) || (sender.isOp())))
    {
      Player p = getOnlinePlayer(args[0]);
      p.setHealth(20);
      p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 5));
      p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000000, 5));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 2));
      p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000000, 5));
      p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000000, 5));
      p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000000000, 5));
      p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000000, 2));
      p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 5));
      sender.sendMessage(PluginLoader.color("&bDer spiler &9" + p.getName() + " &bhat den Energy Drink bekommen!"));
      p.sendMessage(PluginLoader.color("&bDer Spieler &9" + sender.getName() + " &bhat dir den Energy Drink gegeben!"));
      return true;
    }

    return false;
  }
}