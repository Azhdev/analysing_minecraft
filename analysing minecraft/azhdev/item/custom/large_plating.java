package item.custom;

import item.itemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import anmc.analysing_minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class large_plating extends Item {
	public large_plating(int ID){
		super(ID);
		this.setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.largeplating_UNLOCALIZEDNAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.largeplating_ICON);
	}
}
