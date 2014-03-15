package azhdev.anmc.blocks.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

/**
 * 
 * TileEntityExtractPipe.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class TileEntityExtractPipe extends TileEntity implements IHopper, IInventory{

	public ItemStack[] items;
	
	public int inventorySize = 4;
	public int transferCooldown;
	public int cooldownConstant = 200;
	
	public TileEntityExtractPipe(){
		items = new ItemStack[inventorySize];
	}
	
	@Override
	public int getSizeInventory() {
		return inventorySize;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return items[var1];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int decrAmount) {
		ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null){
        	
            if (itemStack.stackSize <= decrAmount){
            	
                setInventorySlotContents(slotIndex, null);
                
            }else{
            	
                itemStack = itemStack.splitStack(decrAmount);
                if(itemStack.stackSize == 0){
                		
                	setInventorySlotContents(slotIndex, null);
                }
            }
        }
        return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack itemStack = getStackInSlot(var1);
        if (itemStack != null){
            setInventorySlotContents(var1, null);
        }
        return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) {
		items[slotIndex] = itemStack;
        if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()){
            itemStack.stackSize = getInventoryStackLimit();
        }
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		
		//saving the items
		for(int i = 0; i < getSizeInventory(); i++){
			
			ItemStack stack = getStackInSlot(i);
			
			if(stack != null){
			
				NBTTagCompound item = new NBTTagCompound();
				
				item.setByte("slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		//saving the misc variables
		compound.setInteger("transferCooldown", transferCooldown);
		
		compound.setTag("Items", items);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		
		
		//reading the items 
		for(int i = 0; i < items.tagCount();i++){
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			int slot = item.getByte("slot");
			if(slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		
		//reading the misc variables
		transferCooldown = compound.getInteger("transferCooldown");
	}
	
	@Override
	public String getInventoryName() {
		return "pipe";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return var1.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return false;
	}
	
	@Override
	public double getXPos() {
		return 0;
	}

	@Override
	public double getYPos() {
		return 0;
	}

	@Override
	public double getZPos() {
		return 0;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
}
