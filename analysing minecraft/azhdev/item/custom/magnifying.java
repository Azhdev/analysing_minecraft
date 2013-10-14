package item.custom;

import item.itemInfo;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class magnifying extends Item {
	public magnifying(int ID){
		super(ID);
		setCreativeTab(analysing_minecraft.tabsAM);
		setUnlocalizedName(itemInfo.magnifying_UNLOCALIZEDNAME);
		setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	private Icon idle;
	@SideOnly(Side.CLIENT)
	private Icon active;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.Magnifying_ICON);
		active = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.Magnifying_ACTIVE);
	}
	public Icon getIcon(){
			return idle;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player,List info, boolean useExtraInformation) {
		info.add("use this item in an analyser");
	}
}
