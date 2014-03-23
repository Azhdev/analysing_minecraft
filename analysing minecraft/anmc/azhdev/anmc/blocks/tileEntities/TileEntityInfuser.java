package azhdev.anmc.blocks.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityInfuser extends TileEntity implements IInventory{

	private ItemStack[] items;
	
	public int inventorySize = 4;
	
	private static int totalCookTime = 200;
	private static int currentCookTime;
	private static int remainingBurnTime = totalCookTime - currentCookTime;
	
	public TileEntityInfuser(){
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
	public String getInventoryName() {
		return "Infuser";
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
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		
		compound.setInteger("currentCookTime", currentCookTime);
		compound.setInteger("remainingBurnTime", remainingBurnTime);
		
		for(int i = 0; i < getSizeInventory(); i++){
			
			ItemStack stack = getStackInSlot(i);
			
			if(stack != null){
			
				NBTTagCompound item = new NBTTagCompound();
				
				item.setByte("slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("Items", items);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		
		for(int i = 0; i < items.tagCount();i++){
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			int slot = item.getByte("slot");
			if(slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void markDirty() {
		
	}	
}
