package blocks.machines;

import blocks.blockInfo;
import blocks.tileEntities.TileEntityAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import anmc.analysing_minecraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Analyzer extends BlockContainer {
	public Analyzer(int ID){
		super(ID, blockInfo.MACHINE_MATERIAL);
		setCreativeTab(analysing_minecraft.tabsAM);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(blockInfo.ANALYSER_TE_UNLOCALIZEDNAME);
	}	
	@SideOnly(Side.CLIENT)
	private Icon otherIcon;
	@SideOnly(Side.CLIENT)
	private Icon TopIcon;
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		otherIcon = register.registerIcon(blockInfo.TEXTURELOCATION + ":" + blockInfo.ANALYSER_ICON);
		TopIcon = register.registerIcon(blockInfo.TEXTURELOCATION + ":" + blockInfo.ANALYSER_TOP);
	}	
	public Icon getIcon(int side, int meta) {
		if(side == 1){
			return TopIcon;
		}else{
			return otherIcon;
		}
	}	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAnalyzer();
	}
}
