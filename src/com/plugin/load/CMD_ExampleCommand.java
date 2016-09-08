package com.plugin.load;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.coder.client.main.CoderCommand;
import com.coder.client.main.MultiReplacer;

public class CMD_ExampleCommand extends CoderCommand {

	public CMD_ExampleCommand(String name) {
		super(name);
		//Beschreibung des Commands
		description = "Beispiel";
		//Nutzung des Commands
		usageMessage = "/"+name;
		//Permission des Commands
		setPermission("coder.examp");
	}

	@Override
	public boolean onCmd(CommandSender arg0, String[] args) {
		//Der Sender als Spieler
		Player sender = (Player)arg0;
		//Überprüfung auf die Permission
		if(hasPermission(sender)) {
			//Überprüfung der Argumente
			if(args.length<1) {
				//Erfolgreich
				
				//Ein %object% ersetzen
				//In der Nachricht wird %player% durch den Spielernamenersetzt mit .replace()
				msg(sender, "Hallo %player%".replace("%player%", sender.getName()));
				
				//Mehere %object% %object2% ersetzen (noch nicht vereinfacht)
				MultiReplacer mr = new MultiReplacer();
				Map<String, String> tokens = new HashMap<String, String>();
				tokens.put("player", sender.getName());
				tokens.put("greeting", "Hallo");
				String desing = "%greeting% %player%";
				//In der Nachricht wird im Desing %greeting% durch Hallo, und %player% durch den Spielernamen ersetzt!
				msg(sender, mr.replaceAllTokens(tokens, desing));
				
				msg(sender, "Erfolgreich!");
				return true;
			}
		}
		return false;
	}

}
