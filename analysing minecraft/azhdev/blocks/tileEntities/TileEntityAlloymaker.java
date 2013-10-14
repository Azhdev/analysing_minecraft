package blocks.tileEntities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlloymaker extends TileEntity implements IInventory{
	
	private ItemStack[] AlloymakerItemStacks = new ItemStack[5];
	public static int progress = 0;
	

	@Override
	public int getSizeInventory() {
		 return this.AlloymakerItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.AlloymakerItemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.AlloymakerItemStacks[i] != null)
        {
            ItemStack itemstack;

            if (this.AlloymakerItemStacks[i].stackSize <= j)
            {
                itemstack = this.AlloymakerItemStacks[i];
                this.AlloymakerItemStacks[i] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.AlloymakerItemStacks[i].splitStack(j);

                if (this.AlloymakerItemStacks[i].stackSize == 0)
                {
                    this.AlloymakerItemStacks[i] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		 if (this.AlloymakerItemStacks[i] != null)
	        {
	            ItemStack itemstack = this.AlloymakerItemStacks[i];
	            this.AlloymakerItemStacks[i] = null;
	            return itemstack;
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		 this.AlloymakerItemStacks[i] = itemstack;

	        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
	        {
	            itemstack.stackSize = this.getInventoryStackLimit();
	        }
	}

	@Override
	public String getInvName() {
		 return "container.Alloymaker";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.AlloymakerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.AlloymakerItemStacks.length)
            {
                this.AlloymakerItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
	
	@Override
	 public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeToNBT(par1NBTTagCompound);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.AlloymakerItemStacks.length; ++i)
	        {
	            if (this.AlloymakerItemStacks[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.AlloymakerItemStacks[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        par1NBTTagCompound.setTag("Items", nbttaglist);
	    }
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	public void updateEntity(){
		
    }
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return false;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
}
