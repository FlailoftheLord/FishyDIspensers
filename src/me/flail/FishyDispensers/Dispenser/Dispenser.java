package me.flail.FishyDispensers.Dispenser;

import org.bukkit.inventory.ItemStack;

import me.flail.FishyDispensers.fd.DispenserType;

public class Dispenser extends ItemStack implements IDispenser {

	public Dispenser(DispenserType type) {
		this.setType(type);
	}


	@Override
	public void setType(DispenserType type) {

	}

}
