package azhdev.anmc.items.custom;

import net.minecraft.client.renderer.texture.IIconRegister;
import azhdev.anmc.Generic.AzhdevItem;

public class speedUpgrade extends AzhdevItem {
	public speedUpgrade(){
		super();
	}
	
	@Override
	public void registerIcons(IIconRegister register){
		itemIcon = register.registerIcon("anmc:upgradeSpeed");
	}
}
