package azhdev.anmc.client.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import azhdev.anmc.blocks.tileEntities.TileEntityInfuser;
import azhdev.anmc.client.Slots.SlotInfuserOutput;

/**
 * 
 * ContainerInfuser.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class ContainerInfuser extends Container{

	private TileEntityInfuser infuser;
	private final int playerInvRows = 3;
	private final int playerInvColumns = 9;
	private final int xCoordFirstSlotInRowPlayerInv = 8;
	private final int yCoordFirstSlotInColumnPlayerInv = 72;
		
	public ContainerInfuser(InventoryPlayer playerInv, TileEntityInfuser infuser){
		this.infuser = infuser;
		
		addInfuserSlots(playerInv, infuser);
		addVanillaSlots(playerInv, infuser);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return infuser.isUseableByPlayer(var1);
	}
	
	private void addInfuserSlots(InventoryPlayer playerInv, TileEntityInfuser infuser){
		this.addSlotToContainer(new Slot(infuser, 0, 8, 17));
		this.addSlotToContainer(new Slot(infuser, 1, 26, 17));
		this.addSlotToContainer(new Slot(infuser, 2, 44, 17));
		this.addSlotToContainer(new SlotInfuserOutput(infuser, 3, 118, 17));
		this.addSlotToContainer(new Slot(infuser, 4, 26, 50));
	}
	
	public void addVanillaSlots(InventoryPlayer playerInv, TileEntityInfuser infuser){
		
		for(int inventoryRowIndex = 0; inventoryRowIndex < playerInvRows; inventoryRowIndex++){
			for(int inventoryColumnIndex = 0; inventoryColumnIndex < playerInvColumns; inventoryColumnIndex++){
				this.addSlotToContainer(new Slot(playerInv, inventoryColumnIndex + inventoryRowIndex * 9 + 9, xCoordFirstSlotInRowPlayerInv + inventoryColumnIndex * 18, yCoordFirstSlotInColumnPlayerInv + inventoryRowIndex * 18));
			}
		}
		
		for(int hotBarSlotIndex = 0; hotBarSlotIndex < playerInvColumns; hotBarSlotIndex++){
			this.addSlotToContainer(new Slot(playerInv, hotBarSlotIndex, 8 + hotBarSlotIndex * 18, 130));
		}
	}
}
