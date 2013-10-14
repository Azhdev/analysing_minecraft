package item.custom;

import item.itemInfo;
import anmc.analysing_minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class hoeCremomium extends ItemHoe {
	public hoeCremomium(int ID, EnumToolMaterial EnumToolMaterial){
		super(ID, analysing_minecraft.Cremomium);
		this.setUnlocalizedName(itemInfo.hoeCremomium_UNLOCALIZEDNAME);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
}
