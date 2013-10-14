package item.ingots;

import item.itemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import anmc.analysing_minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ingotCremomium extends Item {
	public ingotCremomium(int ID){
		super(ID);
		setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.ingotCremomium_UNLOCALIZEDNAME);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.ingotCremomium_ICON);
	}
}
