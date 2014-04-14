package azhdev.anmc.items.custom;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import azhdev.anmc.Generic.AzhdevItem;
import azhdev.anmc.entities.entityBattery;

public class ItemBattery extends AzhdevItem{
	public ItemBattery(){
		super();
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			world.spawnEntityInWorld(new entityBattery(world, x + 0.5, y + 1.5, z + 0.5));
			itemstack.stackSize--;
			return true;
		}else{
			return false;
		}
		
	}
}
