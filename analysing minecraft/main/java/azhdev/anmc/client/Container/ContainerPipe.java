package azhdev.anmc.client.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.client.Slots.pipeUpgradeSlot;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class ContainerPipe extends Container{

	private tileEntityPipe pipe;
	private final int playerInvRows = 3;
	private final int playerInvColumns = 9;
	private final int xCoordFirstSlotInRowPlayerInv = 8;
	private final int yCoordFirstSlotInColumnPlayerInv = 72;
	
	
	public ContainerPipe(InventoryPlayer playerInv, tileEntityPipe pipe){
		this.pipe = pipe;
		
		addVanillaSlots(playerInv, pipe);
		addPipeSlots(playerInv, pipe);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return pipe.isUseableByPlayer(var1);
	}
	
	private void addPipeSlots(InventoryPlayer playerInv, tileEntityPipe pipe){
		this.addSlotToContainer(new Slot(pipe, 0, 80, 17));
	}
	
	private void addVanillaSlots(InventoryPlayer playerInv, tileEntityPipe pipe){
		
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
