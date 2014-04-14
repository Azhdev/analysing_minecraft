package azhdev.anmc.blocks.custom;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class CeneriumOre extends BlockOre {

	public CeneriumOre() {
		super();
		this.setBlockName(getClass().getSimpleName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("anmc:CeneriumOre");
	}
}
