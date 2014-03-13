package azhdev.anmc.blocks.custom;

import net.minecraft.block.material.Material;
import azhdev.anmc.generic.anmcBlock;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class battery extends anmcBlock {

	public battery(Material mat) {
		super(mat);
		setBlockName("battery");
		setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	
}
