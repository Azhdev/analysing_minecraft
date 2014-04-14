package azhdev.anmc.blocks.custom;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import azhdev.anmc.Generic.AzhdevBlockContainer;
import azhdev.anmc.blocks.tileEntities.TileEntityILM;

public class ILMBlock extends AzhdevBlockContainer {

	public ILMBlock(Material mat) {
		super(mat);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityILM();
	}
}
