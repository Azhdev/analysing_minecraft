package item.research;

import item.itemInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class scroll extends Item{

	public scroll(int ID) {
		super(ID);
		setCreativeTab(analysing_minecraft.tabsAM);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(itemInfo.TEXTURE_LOCATION + ":" + itemInfo.scroll_ICON);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
	     player.openGui(analysing_minecraft.instance, 1, player.worldObj, x, y, z);
	     System.out.println("test");
	     return stack;
    }
}