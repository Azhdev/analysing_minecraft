package blocks.machines;

import anmc.analysing_minecraft;
import blocks.blockInfo;
import blocks.tileEntities.tileEntityPowerer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class blockPowerer extends BlockContainer{

	public blockPowerer(int ID, Material material) {
		super(ID, material);
		setCreativeTab(analysing_minecraft.tabsAM);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(blockInfo.POWERER_UNLOCALIZEDNAME);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new tileEntityPowerer();
	}

}
