package azhdev.anmc.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import azhdev.anmc.Generic.AzhdevBlockContainer;
import azhdev.anmc.blocks.tileEntities.TileEntityILMCable;

public class BlockILMCable extends AzhdevBlockContainer{

	public BlockILMCable(Material mat) {
		super(mat);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2){
		return new TileEntityILMCable();
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor) {
		TileEntityILMCable cable =  (TileEntityILMCable) world.getTileEntity(x, y, z);
		cable.updateCable(world, x, y, z);
	}
}
