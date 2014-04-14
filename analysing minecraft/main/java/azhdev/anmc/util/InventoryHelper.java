package azhdev.anmc.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import azhdev.anmc.blocks.custom.extractPipe;
import azhdev.anmc.blocks.tileEntities.TileEntityExtractPipe;
import azhdev.anmc.misc.ExtractorPipe;

/**
 * 
 * InventoryHelper.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 *
 *a helper class for inventories
 */

public class InventoryHelper {
		
	public static IInventory getInventoryAtLocation(World world, double x, double y, double z){
        IInventory Inv = null;
        int xPos = MathHelper.floor_double(x);
        int yPos = MathHelper.floor_double(y);
        int zPos = MathHelper.floor_double(z);
        TileEntity tile = world.getTileEntity(xPos, yPos, zPos);

        if (tile != null && tile instanceof IInventory){
            Inv = (IInventory)tile;

            if (Inv instanceof TileEntityChest){
                Block block = world.getBlock(xPos, yPos, zPos);
                
                if (block instanceof BlockChest){
                    Inv = (IInventory) ((BlockChest)block);
                }
            }
        }

        if (Inv == null){
            List var14 = world.getEntitiesWithinAABBExcludingEntity((Entity)null, AxisAlignedBB.getAABBPool().getAABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.selectInventories);

            if (var14 != null && var14.size() > 0){
                Inv = (IInventory)var14.get(world.rand.nextInt(var14.size()));
            }
        }

        return Inv;
    }
	
	public static boolean areItemStacksEqualItem(ItemStack par0ItemStack, ItemStack par1ItemStack){
        return par0ItemStack.getItem() != par1ItemStack.getItem() ? false : (par0ItemStack.getItemDamage() != par1ItemStack.getItemDamage() ? false : (par0ItemStack.stackSize > par0ItemStack.getMaxStackSize() ? false : ItemStack.areItemStackTagsEqual(par0ItemStack, par1ItemStack)));
    }
	
	public static EntityItem getEntityAbove(World world, double x, double y, double z){
        List var7 = world.selectEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getAABBPool().getAABB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D), IEntitySelector.selectAnything);
        return var7.size() > 0 ? (EntityItem)var7.get(0) : null;
    }
	
	public static boolean canInsertItemToInventory(IInventory par0IInventory, ItemStack par1ItemStack, int par2, int par3){
        return !par0IInventory.isItemValidForSlot(par2, par1ItemStack) ? false : !(par0IInventory instanceof ISidedInventory) || ((ISidedInventory)par0IInventory).canInsertItem(par2, par1ItemStack, par3);
    }

    public static boolean canExtractItemFromInventory(IInventory par0IInventory, ItemStack par1ItemStack, int par2, int par3){
        return !(par0IInventory instanceof ISidedInventory) || ((ISidedInventory)par0IInventory).canExtractItem(par2, par1ItemStack, par3);
    }
    
    public static ItemStack insertStack(IInventory par0IInventory, ItemStack par1ItemStack, int par2){
        if (par0IInventory instanceof ISidedInventory && par2 > -1){
            ISidedInventory var6 = (ISidedInventory)par0IInventory;
            int[] var7 = var6.getAccessibleSlotsFromSide(par2);

            for (int var5 = 0; var5 < var7.length && par1ItemStack != null && par1ItemStack.stackSize > 0; ++var5){
                par1ItemStack = func_102014_c(par0IInventory, par1ItemStack, var7[var5], par2);
            }
        }
        else
        {
            int var3 = par0IInventory.getSizeInventory();

            for (int var4 = 0; var4 < var3 && par1ItemStack != null && par1ItemStack.stackSize > 0; ++var4)
            {
                par1ItemStack = func_102014_c(par0IInventory, par1ItemStack, var4, par2);
            }
        }

        if (par1ItemStack != null && par1ItemStack.stackSize == 0)
        {
            par1ItemStack = null;
        }

        return par1ItemStack;
    }
    
    private static ItemStack func_102014_c(IInventory par0IInventory, ItemStack par1ItemStack, int par2, int par3)
    {
        ItemStack var4 = par0IInventory.getStackInSlot(par2);

        if (canInsertItemToInventory(par0IInventory, par1ItemStack, par2, par3))
        {
            boolean var5 = false;

            if (var4 == null)
            {
                par0IInventory.setInventorySlotContents(par2, par1ItemStack);
                par1ItemStack = null;
                var5 = true;
            }
            else if (areItemStacksEqualItem(var4, par1ItemStack))
            {
                int var6 = par1ItemStack.getMaxStackSize() - var4.stackSize;
                int var7 = Math.min(par1ItemStack.stackSize, var6);
                par1ItemStack.stackSize -= var7;
                var4.stackSize += var7;
                var5 = var7 > 0;
            }

            if (var5)
            {
                if (par0IInventory instanceof TileEntityExtractPipe)
                {
                    ((TileEntityExtractPipe)par0IInventory).setTransferCooldown(8);
                    par0IInventory.markDirty();
                }

                par0IInventory.markDirty();
            }
        }

        return par1ItemStack;
    }
    
    public static boolean suckItemsIntoExtractor(ExtractorPipe pipe){
        IInventory Inv = getInventoryAboveHopper(pipe);

        if (Inv != null){
            byte var2 = 0;

            if (Inv instanceof ISidedInventory && var2 > -1){
                ISidedInventory sidedInv = (ISidedInventory)Inv;
                int[] var8 = sidedInv.getAccessibleSlotsFromSide(var2);

                for (int var5 = 0; var5 < var8.length; ++var5){
                    if (insertStackFromInventory(pipe, Inv, var8[var5], var2)){
                        return true;
                    }
                }
            }else{
                int Size = Inv.getSizeInventory();

                for (int i = 0; i < Size; i++){
                    if (insertStackFromInventory(pipe, Inv, i, var2)){
                        return true;
                    }
                }
            }
        }else{
            EntityItem ItemEntity = getEntityAbove(pipe.getWorldObj(), pipe.getXpos(), pipe.getYpos() + 1.0D, pipe.getZpos());

            if (ItemEntity != null){
                return insertStackFromEntity(pipe, ItemEntity);
            }
        }

        return false;
    }
    
    public static boolean insertStackFromEntity(IInventory pipe, EntityItem itemEntity) {
    	boolean var2 = false;

        if (itemEntity == null)
        {
            return false;
        }
        else
        {
            ItemStack var3 = itemEntity.getEntityItem().copy();
            ItemStack var4 = insertStack(pipe, var3, -1);

            if (var4 != null && var4.stackSize != 0)
            {
                itemEntity.setEntityItemStack(var4);
            }
            else
            {
                var2 = true;
                itemEntity.setDead();
            }

            return var2;
        }
	}

	public static boolean insertStackFromInventory(ExtractorPipe pipe, IInventory inv, int i, int j) {
		ItemStack theStack = inv.getStackInSlot(i);

        if (theStack != null && canExtractItemFromInventory(inv, theStack, i, j)){
            ItemStack theStackCopy = theStack.copy();
            ItemStack var6 = insertStack(pipe, inv.decrStackSize(i, 1), -1);

            if (var6 == null || var6.stackSize == 0)
            {
                inv.markDirty();
                return true;
            }

            inv.setInventorySlotContents(i, theStackCopy);
        }

        return false;
	}

	public static IInventory getInventoryAboveHopper(ExtractorPipe pipe){
        return getInventoryAtLocation(pipe.getWorldObj(), pipe.getXpos(), pipe.getYpos() + 1.0D, pipe.getZpos());
    }	
}