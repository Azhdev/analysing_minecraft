package azhdev.anmc.Generic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityILGeneric extends TileEntity implements IInventory{

	/**
	* boolean[] for storing the connected sides
	* 0 = xPos
	* 1 = xNeg
	* 2 = zPos
	* 3 = zNeg
	* 4 = top
	* 5 = bottom
	*/
	private static boolean[] connectedSides;
	
	@Override
	public void updateEntity(){
		
	}
	
	public void updateCable(World world, int x, int y, int z){
		boolean[] Sides = new boolean[6];
		if(world.getBlock(x + 1, y, z) instanceof IInventory || world.getBlock(x + 1, y, z) instanceof ISidedInventory){
			Sides[0] = true;
		}else{
			Sides[0] = false;
		}
		if(world.getBlock(x - 1, y, z) instanceof IInventory || world.getBlock(x - 1, y, z) instanceof ISidedInventory){
			Sides[1] = true;
		}else{
			Sides[1] = false;
		}
		if(world.getBlock(x, y, z + 1) instanceof IInventory || world.getBlock(x, y, z + 1) instanceof ISidedInventory){
			Sides[2] = true;
		}else{
			Sides[2] = false;
		}
		if(world.getBlock(x, y, z - 1) instanceof IInventory || world.getBlock(x, y, z - 1) instanceof ISidedInventory){
			Sides[3] = true;
		}else{
			Sides[3] = false;
		}
		if(world.getBlock(x, y + 1, z) instanceof IInventory || world.getBlock(x, y + 1, z) instanceof ISidedInventory){
			Sides[4] = true;
		}else{
			Sides[4] = false;
		}
		if(world.getBlock(x, y - 1, z) instanceof IInventory || world.getBlock(x, y - 1, z) instanceof ISidedInventory){
			Sides[5] = true;
		}else{
			Sides[5] = false;
		}
		setAttachedCables(Sides);
	}
	
	private void setAttachedCables(boolean[] sides){
		for(int i = 0; i > 5; i++){
			connectedSides[i] = sides[i];
		}
	}
	
	private boolean[] getConnectedSides(){
		return connectedSides;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		for(int i = 0; i > 5;){
			compound.setBoolean("side:" + i, connectedSides[i]);
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		for(int i = 0; i > 5;){
			connectedSides[i] = compound.getBoolean("side:" + i);
		}
	}
	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return var1.getDistanceSq(xCoord, yCoord, zCoord) <= 4;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}

}
