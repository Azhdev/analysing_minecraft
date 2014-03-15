package azhdev.anmc.client.Slots;

import azhdev.anmc.items.anmcItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class pipeUpgradeSlot extends Slot{

	public pipeUpgradeSlot(IInventory inv, int x, int y, int z) {
		super(inv, x, y, z);

	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack){
		return itemstack.getItem() == anmcItems.upgrade;
	}
	
	@Override
	public int getSlotStackLimit(){
		return 4;
	}
}
