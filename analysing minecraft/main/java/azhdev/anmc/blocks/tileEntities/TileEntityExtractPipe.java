package azhdev.anmc.blocks.tileEntities;

import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import azhdev.anmc.blocks.custom.extractPipe;
import azhdev.anmc.items.anmcItems;
import azhdev.anmc.misc.ExtractorPipe;
import azhdev.anmc.util.InventoryHelper;

/**
 * 
 * TileEntityExtractPipe.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class TileEntityExtractPipe extends TileEntity implements IInventory, ExtractorPipe{
	public ItemStack[] items;
	
	public World world;
	
	public int inventorySize = 4;
	public static int transferCooldown = 0;
	public int cooldownConstant = 200;
	public int outputStack;
	
	public static int speedAmount;
	public static int grabAmount;
	public static int speedTemp;
	public static int grabTemp;
	
	public static int transferTemp;
	
	static int slotsvar = 0;
	static int[] slots = new int[slotsvar];
	
	public TileEntityExtractPipe(){
		items = new ItemStack[inventorySize];
	}
	
	public TileEntityExtractPipe getPipe(int x, int y, int z){
		return (TileEntityExtractPipe)this.worldObj.getTileEntity(x, y, z);
	}
	
	@Override
	public ItemStack getStackInSlot(int var1) {
		return items[var1];
	}
	
	@Override
	public void updateEntity(){
		this.getUpgrades();
		if (this.worldObj != null && !this.worldObj.isRemote){
            this.transferCooldown--;

            if (!this.isCoolingDown()){
                this.setTransferCooldown(0);
                this.updateExtractor();
            }
        }
	}
	
	public boolean updateExtractor() {
		this.getUpgrades();
		if (this.worldObj != null && !this.worldObj.isRemote){
            if (!this.isCoolingDown() && extractPipe.getIsBlockNotPoweredFromMetadata(this.getBlockMetadata())){
                boolean var1 = this.insertItemToInventory();
                var1 = InventoryHelper.suckItemsIntoExtractor(this) || var1;

                if (var1){
                    this.setTransferCooldown(20);
                    this.onInventoryChanged();
                    return true;
                }
            }

            return false;
        }else{
            return false;
        }
	}

	public void onInventoryChanged() {
		super.markDirty();
	}

	public void setTransferCooldown(int i) {
		transferCooldown = i;
		
	}

	private boolean isCoolingDown() {
		return transferCooldown > 0;
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
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	private void setSpeedAmount(int i){
		speedAmount = i;
	}
	
	@Override
	public int getSizeInventory() {
		return items.length;
	}
	
	private static boolean isAbleToMoveitems(TileEntityExtractPipe pipe){
		if(transferCooldown == 0 && pipe.getStackInSlot(0) != null){
			return true;
		}else{
			return false;
		}
	}
	
	public static IInventory getInventoryAtLocation(World world, double x, double y, double z){
        IInventory Inv = null;
        int X = MathHelper.floor_double(x);
        int Y = MathHelper.floor_double(y);
        int Z = MathHelper.floor_double(z);
        TileEntity tile = world.getTileEntity(X, Y, Z);

        if (tile != null && tile instanceof IInventory)
        {
            Inv = (IInventory)tile;
        }

        if (Inv == null)
        {
            List var14 = world.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getAABBPool().getAABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.selectInventories);

            if (var14 != null && var14.size() > 0)
            {
                Inv = (IInventory)var14.get(world.rand.nextInt(var14.size()));
            }
        }

        return Inv;
    }
	
	private IInventory getOutputInventory(){
        int var1 = extractPipe.getDirectionFromMetadata(this.getBlockMetadata());
        return getInventoryAtLocation(this.getWorldObj(), (double)(this.xCoord + Facing.offsetsXForSide[var1]), (double)(this.yCoord + Facing.offsetsYForSide[var1]), (double)(this.zCoord + Facing.offsetsZForSide[var1]));
    }

	@Override
	public double getXpos() {
		return 0;
	}

	@Override
	public double getYpos() {
		return 0;
	}

	@Override
	public double getZpos() {
		return 0;
	}
	
	public boolean insertItemToInventory() {
		IInventory var1 = this.getOutputInventory();

        if (var1 == null){
            return false;
        }else{
            if (this.getStackInSlot(0) != null){
            	ItemStack var3 = this.getStackInSlot(0).copy();
                ItemStack var4 = InventoryHelper.insertStack(var1, this.decrStackSize(0, 1), Facing.oppositeSide[extractPipe.getDirectionFromMetadata(this.getBlockMetadata())]);

                if (var4 == null || var4.stackSize == 0){
                	var1.markDirty();
                    return true;
                }

                this.setInventorySlotContents(0, var3);
            }

            return false;
        }
	}
	
	private  void getUpgrades(){
		speedTemp = 0;
		grabTemp = 0;
		for(int i = 1; i > 3; i++){
			if(this.getStackInSlot(i).getItem() == anmcItems.upgrade){
				speedTemp = speedTemp + this.getStackInSlot(i).stackSize;
				//System.out.println("okay");
			}else if(this.getStackInSlot(i).getItem() == anmcItems.suckUpgrade){
				grabTemp = grabTemp + this.getStackInSlot(i).stackSize;
			}
		}
		setSpeedAmount(speedTemp * 2);
		grabAmount = grabTemp;
	}
}
