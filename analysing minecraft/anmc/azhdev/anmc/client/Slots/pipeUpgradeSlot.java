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
		if(itemstack.getItem() == anmcItems.upgrade || itemstack.getItem() == anmcItems.suckUpgrade){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public int getSlotStackLimit(){
		return 4;
	}
}
