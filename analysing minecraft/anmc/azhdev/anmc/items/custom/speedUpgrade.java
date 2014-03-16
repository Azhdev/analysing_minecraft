package azhdev.anmc.items.custom;

import net.minecraft.client.renderer.texture.IIconRegister;
import azhdev.anmc.generic.anmcItem;

public class speedUpgrade extends anmcItem {
	public speedUpgrade(){
		super();
	}
	
	@Override
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("anmc:upgradeSpeed");
	}
}
