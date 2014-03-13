package azhdev.anmc.blocks.custom;

import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class Pipe extends BlockContainer{

	public Pipe(Material material) {
		super(material);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new tileEntityPipe();
	}

}
