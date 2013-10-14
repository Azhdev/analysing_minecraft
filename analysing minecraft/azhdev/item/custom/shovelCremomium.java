package item.custom;

import item.itemInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class shovelCremomium extends ItemSpade {
	public shovelCremomium(int ID, EnumToolMaterial EnumToolMaterial){
		super(ID, analysing_minecraft.Cremomium);
		this.setUnlocalizedName(itemInfo.shovelCremomium_UNLOCALIZEDNAME);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.shovelCremomium_ICON);
	}
}
