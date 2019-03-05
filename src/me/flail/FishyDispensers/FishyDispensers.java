package me.flail.FishyDispensers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class FishyDispensers extends JavaPlugin {

	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	public Server server = this.getServer();

	public String version = this.getDescription().getVersion();

	@Override
	public void onEnable() {
		// Load up the config file
		saveDefaultConfig();

		// Register the events and commands
		Bukkit.getPluginManager().registerEvents(new DispenseEvent(), this);
		this.getCommand("fishydispensers").setExecutor(new Commands());

		// spam your console :>
		console.sendMessage(chat("&2Welcome to ur home for"));
		console.sendMessage(chat("   &3Fishy Dispensers!!"));
		console.sendMessage(chat("  &7v" + version + " &2by FlailoftheLord."));

	}

	@Override
	public void onDisable() {
		server.getScheduler().cancelTasks(this);
		console.sendMessage(chat("&3Bye&2Bye!"));
	}

	public String chat(String m) {

		String prefix = getConfig().getString("Prefix");

		String result = ChatColor.translateAlternateColorCodes('&', m.replace("%prefix%", prefix));
		return result;

	}

}
