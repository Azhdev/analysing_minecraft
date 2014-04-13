package azhdev.anmc.client.Slots;

import azhdev.anmc.items.anmcItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotInfuserOutput extends Slot{

	public SlotInfuserOutput(IInventory inv, int x, int y, int z) {
		super(inv, x, y, z);

	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack){
		return true; //itemstack.getItem() == anmcItems.ingot;
	}
}
