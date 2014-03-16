package azhdev.anmc.blocks.tileEntities;

import azhdev.anmc.items.anmcItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class tileEntityPipe extends TileEntity implements IHopper, IInventory{

	public ItemStack[] items;
	
	public ForgeDirection direction;
	
	public int inventorySize = 4;
	public int transferCooldown;
	public int cooldownConstant = 200;
	
	public tileEntityPipe(){
		items = new ItemStack[inventorySize];
	}
	
	@Override
	public void updateEntity(){
		
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
	
	private void insertItem(World world, int x, int y, int z){
		if(canInsertItem(world, x, y, z)){
			
		}
	}
	
	private boolean canInsertItem(World world, int x, int y, int z){
		int var1 = 0;
		if(!world.isRemote){
			
			TileEntity te = world.getTileEntity(x, y, z);
			if(te instanceof IInventory){
				for(int i = 0; i < ((IInventory) te).getSizeInventory(); i++){
					if(((IInventory) te).getStackInSlot(i).stackSize < 65){
						var1++;
					}
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
		if(var1 > 0){
			return true;
		}
		return false;
	}
	
	public void getUpgrades(tileEntityPipe pipe){
		
		int speedAmount = 0;
		int grabAmount = 0;
		
		for(int i = 0; i < 3; i++){
			ItemStack stack = pipe.getStackInSlot(i+1);
			if(stack.getItem() == anmcItems.upgrade){
				speedAmount = stack.stackSize;
			}else if (stack.getItem() == anmcItems.suckUpgrade){
				grabAmount = stack.stackSize;
			}
		}
	}
}
