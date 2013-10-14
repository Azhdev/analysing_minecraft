package item.custom;

import item.itemInfo;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class hatchetCremomium extends ItemAxe {
	public hatchetCremomium(int ID, EnumToolMaterial EnumToolMaterial){
		super(ID, analysing_minecraft.Cremomium);
		setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.hatchetCremomium_UNLOCALIZEDNAME);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.hatchetCremomium_ICON);
	}
}
