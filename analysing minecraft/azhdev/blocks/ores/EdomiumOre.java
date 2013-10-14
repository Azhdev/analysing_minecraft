package blocks.ores;

import blocks.blockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import anmc.analysing_minecraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;

public class EdomiumOre extends Block {
	public EdomiumOre(int ID){
		super(ID, blockInfo.ORE_MATERIAL);
		setCreativeTab(analysing_minecraft.tabsAM);
		setHardness(2F);
		setUnlocalizedName(blockInfo.EDOMIUMORE_UNLOCALIZEDNAME);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(blockInfo.TEXTURELOCATION + ":" + blockInfo.EDOMIUMORE_ICON);
	}
}
