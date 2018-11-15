package me.flail.FishyDispensers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class FishyDispensers extends JavaPlugin {

	public ConsoleCommandSender console = Bukkit.getConsoleSender();

	public String version = this.getDescription().getVersion();

	@Override
	public void onEnable() {
		// Load up the config file
		saveDefaultConfig();

		// Register the events and commands
		Bukkit.getPluginManager().registerEvents(new DispenseEvent(), this);
		this.getCommand("fishydispensers").setExecutor(new Commands());

		// spam your console :>
		console.sendMessage(this.chat("&2Welcome to ur home for"));
		console.sendMessage(this.chat("   &3Fishy Dispensers!!"));
		console.sendMessage(this.chat("  &7v" + version + " &2by FlailoftheLord."));

	}

	@Override
	public void onDisable() {
		console.sendMessage(this.chat("&3Bye&2Bye!"));
	}

	public String chat(String m) {

		String prefix = getConfig().getString("Prefix");

		String result = ChatColor.translateAlternateColorCodes('&', m.replace("%prefix%", prefix));
		return result;

	}

}
