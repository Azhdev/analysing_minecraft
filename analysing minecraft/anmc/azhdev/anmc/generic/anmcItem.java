package azhdev.anmc.generic;

import java.util.List;

import org.lwjgl.input.Keyboard;

import azhdev.anmc.misc.CreativeTabAM;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class anmcItem extends Item{
	
	private String info;
	private Boolean tooltipShowing = false;
	
	public anmcItem(){
		super();
		setUnlocalizedName(getClass().getSimpleName());
	}
	
	public void tooltipOrNot(Boolean showToolTip){
		tooltipShowing = showToolTip;
	}
	public void setInfo(String input){
			info = input;
			
	}
	public String Info(){
		return info;
	}
	
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4){
		if(info == null){
			return;
		}
		if(tooltipShowing){
    		if(Keyboard.isKeyDown(42)){
    			list.add(StatCollector.translateToLocal("< " + Info() + " >"));
    		}else{
    			list.add("< Hold shift for info >");
    		}
		}else{
			return;
		}
    }
	
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("anmc:" + getClass().getSimpleName());
	}
}
