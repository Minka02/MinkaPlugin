package com.plugin.load;

import com.coder.client.main.YmlFile;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config
{
  public void cfgGen()
  {
    YmlFile.setAllPath("ehd/minka");
    YamlConfiguration c = YmlFile.loadConfig("config.yml");
    if (!YmlFile.configExists("config.yml")) {
      YmlFile.generateConfig("config.yml");
      c.set("Prefix", true);
      c.set("Status", false);
      YmlFile.save();
    }
    if(!YmlFile.configExists("messages.yml")) {
    	YmlFile.generateConfig("messages.yml");
    	YamlConfiguration cc = YmlFile.loadConfig("messages.yml");
    	
    	//Nachrichten
    	
    	cc.set("cc.regen.an", "&bRegen ist an");
    	
    	cc.set("cc.regen.aus", "&bRegen ist aus");
    	
    	
    	cc.set("cc.tag", "&bEs ist nun Tag!");
    	
    	cc.set("cc.nacht", "&bEs ist nun Nacht!");
    	

    	
    	YmlFile.save();
    }
  }
}