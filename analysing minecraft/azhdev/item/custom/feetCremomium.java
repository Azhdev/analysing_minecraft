package item.custom;

import item.itemInfo;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class feetCremomium extends ItemArmor {
	public feetCremomium(int ID, EnumArmorMaterial material, int armorType, int renderIndex){
		super(ID, material, armorType, renderIndex);
		armorType = 3;
		setUnlocalizedName(itemInfo.feetCremomium_UNLOCALIZEDNAME);
	}
}
