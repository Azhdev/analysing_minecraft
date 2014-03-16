package azhdev.anmc.blocks.tileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

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
	int r = 0;
	
	
	public TileEntityExtractPipe(){
		items = new ItemStack[inventorySize];
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return items[var1];
	}
	
	@Override
	public void updateEntity(){
		if(r > 0){
			return;
		}else{
			r++;
			getInventoryAtLocation(hopper.getWorldObj(), hopper.getXPos(), hopper.getYPos() + 1.0D, hopper.getZPos()
		}
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
		//super.writeToNBT(compound);
		
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
		return xCoord;
	}

	@Override
	public double getYPos() {
		return yCoord;
	}

	@Override
	public double getZPos() {
		return zCoord;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}
	
	public static IInventory getInventoryAboveHopper(IHopper hopper){
        return getInventoryAtLocation(hopper.getWorldObj(), hopper.getXPos(), hopper.getYPos() + 1.0D, hopper.getZPos());
    }
	
	
	public static IInventory getInventoryAtLocation(World world, double x, double y, double z){
        IInventory var7 = null;
        int var8 = MathHelper.floor_double(x);
        int var9 = MathHelper.floor_double(y);
        int var10 = MathHelper.floor_double(z);
        TileEntity var11 = world.getTileEntity(var8, var9, var10);

        if (var11 != null && var11 instanceof IInventory)
        {
            var7 = (IInventory)var11;

            if (var7 instanceof TileEntityChest)
            {
                Block var12 = world.getBlock(var8, var9, var10);
                
                if (var12 instanceof BlockChest){
                    var7 = (IInventory)((BlockChest)var12);
                }
                System.out.print(var7);
            }
        }
		return var7;
	}
}
