package me.flail.FishyDispensers;

import org.bukkit.ChatColor;
import org.bukkit.block.Dispenser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DispenseEvent implements Listener {

	private FishyDispensers plugin = FishyDispensers.getPlugin(FishyDispensers.class);

	@EventHandler(priority = EventPriority.MONITOR)
	public void dispenseEvent(BlockDispenseEvent event) {

		Dispenser dispenser = (Dispenser) event.getBlock().getState();

		ItemStack item = event.getItem();
		Inventory inventory = dispenser.getSnapshotInventory();

		String eInvName = dispenser.getCustomName();

		String dispenserName = plugin.getConfig().getString("DispenserName");

		String invTitle = ChatColor.translateAlternateColorCodes('&', dispenserName);

		if (eInvName.equals(invTitle)) {

			plugin.server.getScheduler().scheduleSyncDelayedTask(plugin, () -> {

				inventory.addItem(item.clone());
				dispenser.update(true);
			}, 6L);
		}

	}

}
