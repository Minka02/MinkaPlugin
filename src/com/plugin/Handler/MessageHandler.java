package com.plugin.Handler;

import com.plugin.load.PluginLoader;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MessageHandler
  implements Listener
{
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();

    if (e.getPlayer().isOp())
      e.setJoinMessage(PluginLoader.color("&6Wilkommen auf unseren server " + e.getPlayer().getName()));
    else
      e.setJoinMessage(PluginLoader.color("&aWilkommen auf unseren server " + e.getPlayer().getName()));
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent e) {
    if (e.getPlayer().isOp())
      e.setQuitMessage(PluginLoader.color(e.getPlayer().getName() + " &6auf Wiedersehen "));
    else
      e.setQuitMessage(PluginLoader.color(e.getPlayer().getName() + " &aauf Wiedersehen "));
  }

  @EventHandler
  public void onDeath(PlayerDeathEvent e) {
    Player p = e.getEntity();
    e.setDeathMessage(PluginLoader.color(p.getPlayer().getName() + " &4Starb "));
  }
}