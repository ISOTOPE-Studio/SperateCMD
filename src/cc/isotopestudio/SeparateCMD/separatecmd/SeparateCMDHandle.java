package cc.isotopestudio.SeparateCMD.separatecmd;

import java.util.HashMap;

import org.bukkit.entity.Player;

class SeparateCMDHandle {

	static HashMap<String, String> map = new HashMap<>();

	static void add(String name, String command) {
		map.put(name, command);
	}

	static void process(Player player, String arg) {
		String command = map.get(player.getName());
		StringBuilder newCommand = new StringBuilder();
		String[] args = command.split(" ");
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("!arg")) {
				args[i] = arg;
			}
			newCommand.append(args[i]).append(" ");
		}
		map.remove(player.getName());
		player.performCommand(newCommand.toString().substring(1));
	}

}
