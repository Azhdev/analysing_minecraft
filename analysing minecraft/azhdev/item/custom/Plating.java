package item.custom;

import item.itemInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Plating extends Item {
	public Plating(int ID){
		super(ID);
		this.setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.plating_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.plating_ICON);
	}
}
