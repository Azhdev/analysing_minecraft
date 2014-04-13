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
	
	private int firstDist; 
	private int secondDist;
	private int thirdDist;
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		itemstack.setItemDamage(4);
		if(itemstack.getItemDamage() <= 3){
			itemstack.setItemDamage(itemstack.getItemDamage() - 1);
		}
		if(itemstack.getItemDamage() == 0){
			itemstack.stackSize--;
		}
		return itemstack;
    }
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4){
    		if(Keyboard.isKeyDown(42)){
    			if(itemstack.getItemDamage() == 3){
    				list.add(StatCollector.translateToLocal("< " + "first distance = " + firstDist + " >"));
    			}else if(itemstack.getItemDamage() == 2){
    				list.add(StatCollector.translateToLocal("< " + "first distance = " + firstDist + " >"));
    				list.add(StatCollector.translateToLocal("< " + "second distance = " + secondDist + " >"));
    			}else if(itemstack.getItemDamage() == 1){
    				list.add(StatCollector.translateToLocal("< " + "first distance = " + firstDist + " >"));
    				list.add(StatCollector.translateToLocal("< " + "second distance = " + secondDist + " >"));
    				list.add(StatCollector.translateToLocal("< " + "third distance = " + thirdDist + " >"));
    			}else{
    				list.add(StatCollector.translateToLocal("< no distances were set >"));
    			}

    		}else{
    			list.add("< Hold shift for more info");
    		}
    }
	       
}
