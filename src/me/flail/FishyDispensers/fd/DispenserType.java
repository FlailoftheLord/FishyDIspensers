package me.flail.FishyDispensers.fd;

/**
 * A whole collection of different types of dispensers, each of which has a unique purpose.
 * 
 * @author FlailoftheLord
 */
public enum DispenserType {
	/**
	 * Represents a dispenser which never runs out of the item inside.
	 */
	INFINITE,
	/**
	 * Represents a dispenser which can place & break blocks.
	 */
	BLOCK,
	/**
	 * Represents a dispenser which has the capability to use items inside it.
	 * For example, use an axe to chop wood in front of it.
	 */
	ITEM_USE,
	/**
	 * Represents a dispenser which can shoot items directly into a container (chest/hopper/other
	 * dispenser)...
	 */
	ITEM_TRANSFER

}