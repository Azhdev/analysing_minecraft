package azhdev.anmc.client.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import azhdev.anmc.blocks.tileEntities.TileEntityExtractPipe;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.client.Slots.pipeUpgradeSlot;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014� Azhdev
 *
 */

public class containerExtractPipe extends Container{

	private TileEntityExtractPipe pipe;
	private final int playerInvRows = 3;
	private final int playerInvColumns = 9;
	private final int xCoordFirstSlotInRowPlayerInv = 8;
	private final int yCoordFirstSlotInColumnPlayerInv = 72;
	
	
	public containerExtractPipe(InventoryPlayer playerInv, TileEntityExtractPipe pipe){
		this.pipe = pipe;
		
		addVanillaSlots(playerInv, pipe);
		addPipeSlots(playerInv, pipe);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return pipe.isUseableByPlayer(var1);
	}
	
	private void addPipeSlots(InventoryPlayer playerInv, TileEntityExtractPipe pipe){
		this.addSlotToContainer(new Slot(pipe, 0, 80, 17));
		
		this.addSlotToContainer(new pipeUpgradeSlot(pipe, 1, 152, 10));
		this.addSlotToContainer(new pipeUpgradeSlot(pipe, 2, 152, 28));
		this.addSlotToContainer(new pipeUpgradeSlot(pipe, 3, 152, 46));
	}
	
	private void addVanillaSlots(InventoryPlayer playerInv, TileEntityExtractPipe pipe){
		
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
