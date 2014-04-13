package azhdev.anmc.blocks.tileEntities;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import azhdev.anmc.lib.Reference;
import azhdev.anmc.misc.InfuserRecipes;
import azhdev.anmc.util.Log;

/**
 * 
 * TileEntityInfuser.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class TileEntityInfuser extends TileEntity implements IInventory{

	private ItemStack[] items;
	private Item[] recipeItems;
	
	public int inventorySize = 5;
	ForgeDirection d;
	private int totalCookTime = 200;
	private int currentCookTime;
	private int currentItemInfusetime;
	private int remainingBurnTime = totalCookTime - currentCookTime;
	
	public TileEntityInfuser(){
		items = new ItemStack[inventorySize];
	}
	
	@Override
	public void updateEntity(){
		
		boolean var1 = this.currentCookTime > 0;
		boolean var2 = false;
		
		if(this.currentCookTime > 0){
			this.currentCookTime--;
		}
		
		if(!worldObj.isRemote){
			if(this.currentCookTime == 0 && canInfuse()){
				this.currentItemInfusetime = this.currentCookTime = getItemInfuseTime(this.items[4]);
				
				if(this.currentCookTime > 0){
					var2 = true;
					
					if(this.items[4] != null){
						this.items[4].stackSize--;
						
						if(this.items[4].stackSize == 0){
							Item var3 = this.items[4].getItem().getContainerItem();
							this.items[4] = var3 != null ? new ItemStack(var3) : null;
						}
					}
				}
			}
			
			if(this.isInfusing() && this.canInfuse()){
				this.currentCookTime++;
				
				if(this.currentCookTime == totalCookTime){
					this.currentCookTime = 0;
					Log.addInfo("starting infusing item");
					this.infuseItem();
					var2 = true;
				}
			}else{
				this.currentCookTime = 0;
			}
			if(var1 != this.currentCookTime > 0){
				var2 = true;
				
			}
		}
		if(var2){
			this.markDirty();
		}
	}
	
	public boolean isInfusing(){
		return this.currentCookTime > 0;
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
		super.markDirty();
	}
	
	private boolean canInfuse(){
		if(items[0] == null || items[1] == null || items[2] == null){
			return false;
		}
		ItemStack itemstack = InfuserRecipes.getResult(items[0].getItem(), items[1].getItem(), items[2].getItem());
        if (itemstack == null){
        	return false;
        }
        if (this.items[3] == null){
        	return true;
        }
        if (!this.items[3].isItemEqual(itemstack)){
        	return false;
        }
        int result = items[3].stackSize + itemstack.stackSize;
        if(result <= getInventoryStackLimit() && result <= this.items[3].getMaxStackSize()){
        	return true;
        }else{
        	return false;
        }
	}
	
	public void infuseItem(){
		if(this.canInfuse()){
			
			ItemStack var1 = InfuserRecipes.getResult(items[0].getItem(), items[1].getItem(), items[2].getItem());
			
			if(this.items[3] == null){
				this.items[3] = var1.copy();
			}else if(this.items[3].getItem() == var1.getItem()){
				this.items[3].stackSize++;
			}
			
			for(int k = 0; k > 2; k++){
				this.items[k].stackSize--;
				if(this.items[k].stackSize <= 0){
					this.items[k] = null;
				}
			}
			Log.addInfo("infused item");
		}else{
			return;
		}
	}
	
	public static int getItemInfuseTime(ItemStack theStack){
		if(theStack == null){
			return 0;
		}else{
			Item var1 = theStack.getItem();
			Block var2 = Block.getBlockFromItem(var1);
			if(var1 == Items.coal){
				return 2000;
			}
			if(var2 == Blocks.coal_block){
				return 16000;
			}else{
				return 0;
			}
		}
		
	}
	
	public static boolean isItemFuel(ItemStack theStack){
		return getItemInfuseTime(theStack) > 0;
	}
	
	
}
