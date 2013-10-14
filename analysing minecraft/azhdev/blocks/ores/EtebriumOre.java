package blocks.ores;

import blocks.blockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import anmc.analysing_minecraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;

public class EtebriumOre extends Block {
	public EtebriumOre(int ID){
		super(ID, blockInfo.ORE_MATERIAL);
		setCreativeTab(analysing_minecraft.tabsAM);
		setHardness(2F);
		setUnlocalizedName(blockInfo.ETEBRIUMORE_UNLOCALIZEDNAME);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(blockInfo.TEXTURELOCATION + ":" + blockInfo.ETEBRIUMORE_ICON);
	}
}
