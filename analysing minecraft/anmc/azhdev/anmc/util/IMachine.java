package azhdev.anmc.util;

import net.minecraft.nbt.NBTTagCompound;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public interface IMachine {
	/**
	 * Method to get the direction the machine is facing, used for renders.
	 * 
	 * @return direction
	 */
	byte getDirectionFacing();
	/**
	 * Method to set the direction the machine is facing. Handled by BlockECContainer typically.
	 * @param dir
	 */
	void setDirectionFacing(byte dir);
	/**
	 * Gets the type of machine
	 * @return machine type
	 */
	MachineType getMachineType();
	/**
	 * Gets the activity state of the machine.
	 * @return state
	 */
	boolean isActive();
	/**
	 * Sets the value of a specific key within the machine. 
	 * For example, sets the burning speed of Furnaces.
	 * @param key The string identifier
	 * @param value The string value
	 */
	void setMachineProperty(String key, Object value);
	/**
	 * Gets the value of the key passed.
	 * @param key
	 * @return Returns a string representation of the key's value
	 */
	Object getMachineProperty(String key);
	/**
	 * Pass off for writing the machine's properties to the tag. Here
	 * to remind everyone to.
	 * @param mainTag The tag for the tile entity.
	 */
	void writeMachinePropertiesToNBT(NBTTagCompound mainTag);
	/**
	 * Pass off for reading the machine's properties from the tag. Here
	 * to remind everyone to.
	 * @param mainTag The tag for the tile entity.
	 */
	void readMachinePropertiesFromNBT(NBTTagCompound mainTag);
}