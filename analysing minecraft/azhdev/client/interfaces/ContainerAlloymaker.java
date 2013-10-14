package client.interfaces;

import blocks.tileEntities.TileEntityAlloymaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlloymaker extends Container{
	private TileEntityAlloymaker furnace;

	public ContainerAlloymaker(InventoryPlayer inventoryplayer, TileEntityAlloymaker tileentityInputFurnace)
	{
	         furnace = tileentityInputFurnace;
	         this.addSlotToContainer(new Slot(tileentityInputFurnace, 0, 38, 17));
	         this.addSlotToContainer(new Slot(tileentityInputFurnace, 1, 74, 17));
	         this.addSlotToContainer(new Slot(tileentityInputFurnace, 2, 56, 53));
	         this.addSlotToContainer(new slotInputAlloyMaker(inventoryplayer.player, tileentityInputFurnace, 3, 116, 35));
	         for (int i = 0; i < 3; i++)
	         {
	                 for (int k = 0; k < 9; k++)
	                 {
	                         this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
	                 }
	         }
	         for (int j = 0; j < 9; j++)
	         {
	                 this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
	         }
	}

	/**
	         * Looks for changes made in the container, sends them to every listener.
	         */
	

	/**
	         * Called to transfer a stack from one inventory to the other eg. when shift clicking.
	         */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
	         ItemStack itemstack = null;
	         Slot slot = (Slot)inventorySlots.get(par2);
	         if (slot != null && slot.getHasStack())
	         {
	                 ItemStack itemstack1 = slot.getStack();
	                 itemstack = itemstack1.copy();
	                 if (par2 == 2)
	                 {
	                         if (!mergeItemStack(itemstack1, 3, 39, true))
	                         {
	                                 return null;
	                         }
	                 }
	                 else if (par2 >= 3 && par2 < 30)
	                 {
	                         if (!mergeItemStack(itemstack1, 30, 39, false))
	                         {
	                                 return null;
	                         }
	                 }
	                 else if (par2 >= 30 && par2 < 39)
	                 {
	                         if (!mergeItemStack(itemstack1, 3, 30, false))
	                         {
	                                 return null;
	                         }
	                 }
	                 else if (!mergeItemStack(itemstack1, 3, 39, false))
	                 {
	                         return null;
	                 }
	                 if (itemstack1.stackSize == 0)
	                 {
	                         slot.putStack(null);
	                 }
	                 else
	                 {
	                         slot.onSlotChanged();
	                 }
	                 if (itemstack1.stackSize != itemstack.stackSize)
	                 {
	                         slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	                 }
	                 else
	                 {
	                         return null;
	                 }
	         }
	         return itemstack;
	}
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
	         return furnace.isUseableByPlayer(entityplayer);
	}
}
