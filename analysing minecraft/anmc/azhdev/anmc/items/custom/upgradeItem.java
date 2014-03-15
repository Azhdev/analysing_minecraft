package azhdev.anmc.items.custom;

import net.minecraft.client.renderer.texture.IIconRegister;
import azhdev.anmc.generic.anmcItem;

public class upgradeItem extends anmcItem {
	public upgradeItem(){
		super();
	}
	
	@Override
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("anmc:upgradeSpeed");
	}
}
