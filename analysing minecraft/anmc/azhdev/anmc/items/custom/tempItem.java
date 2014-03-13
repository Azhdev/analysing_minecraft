package azhdev.anmc.items.custom;

import azhdev.anmc.entities.entityBattery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class tempItem extends Item{
	public tempItem(){
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
