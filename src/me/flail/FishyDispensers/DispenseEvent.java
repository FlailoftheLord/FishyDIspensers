package me.flail.FishyDispensers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class DispenseEvent implements Listener {

	private FishyDispensers plugin = FishyDispensers.getPlugin(FishyDispensers.class);

	private Server server = Bukkit.getServer();

	@EventHandler
	public void dispenseEvent(BlockDispenseEvent event) {

		Block eBlock = event.getBlock();

		Inventory eInv = (((InventoryHolder) eBlock.getState()).getInventory());

		ItemStack eItem = event.getItem();

		String eInvName = eInv.getTitle();

		String dispenserName = plugin.getConfig().getString("DispenserName");

		String invTitle = ChatColor.translateAlternateColorCodes('&', dispenserName);

		if (eInvName.equalsIgnoreCase(invTitle)) {

			server.getScheduler().scheduleSyncDelayedTask(plugin, () -> {

				eInv.addItem(eItem);

			}, 10);

			event.getBlock().getState().update();

		}

	}

}
