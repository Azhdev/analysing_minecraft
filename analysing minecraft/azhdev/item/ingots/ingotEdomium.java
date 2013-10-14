package item.ingots;

import item.itemInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ingotEdomium extends Item {
	public ingotEdomium(int ID){
		super(ID);
		setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.ingotEdomium_UNLOCALIZEDNAME);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.ingotEdomium_ICON);
	}
}
