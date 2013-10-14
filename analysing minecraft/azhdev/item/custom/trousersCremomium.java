package item.custom;

import item.itemInfo;
import anmc.analysing_minecraft;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class trousersCremomium extends ItemArmor {
	public trousersCremomium(int ID, EnumArmorMaterial material, int renderIndex, int armortype){
		super(ID, material, renderIndex, armortype);
		armortype = 2;
		setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.trousersCremomium_UNLOCALIZEDNAME);
	}
	
}
