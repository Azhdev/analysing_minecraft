package azhdev.anmc.items.custom;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import azhdev.anmc.Generic.AzhdevItem;
import azhdev.anmc.items.anmcItems;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class treasureMap extends AzhdevItem{
	
	public treasureMap() {
		super();
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		if(!Keyboard.isKeyDown(42)){
			if(itemstack.getItemDamage() == 0){
				itemstack.setItemDamage(1);
				return itemstack;
			}
			if(itemstack.getItemDamage() >= 1){
				itemstack.setItemDamage(itemstack.getItemDamage() + 1);
			}
		}else{
			itemstack.stackSize--;
		}
		return itemstack;
    }
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4){
    		if(Keyboard.isKeyDown(42)){
    			if(itemstack.getItemDamage() == 1){
    				list.add("< " + "first distance = "   + " >");
    			}else if(itemstack.getItemDamage() == 2){
    				list.add("< " + "first distance = "   + " >");
    				list.add("< " + "second distance = "  + " >");
    			}else if(itemstack.getItemDamage() == 3){
    				list.add("< " + "first distance = "   + " >");
    				list.add("< " + "second distance = "   + " >");
    				list.add("< " + "third distance = " + " >");
    			}else if(itemstack.getItemDamage() >= 4){
    				list.add("< " + "first distance = "   + " >");
    				list.add("< " + "second distance = "   + " >");
    				list.add("< " + "third distance = " + " >");
    			}else{
    				list.add("< no distances were set >");
    			}

    		}else{
    			list.add("< shiftclicking will remove the item from your inventory >");
    			list.add("< only shiftclick when you found the chest >");
    			list.add("< there will be no other way to retreive the coordinates >");
    			list.add("< Hold shift for more info >");
    		}
    }
	       
}
