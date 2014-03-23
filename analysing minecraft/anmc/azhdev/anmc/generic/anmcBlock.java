package azhdev.anmc.generic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import azhdev.anmc.misc.CreativeTabAM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class anmcBlock extends Block {

	public anmcBlock(Material material) {
		super(material);
		setBlockName(getClass().getSimpleName());
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("anmc:" + getClass().getSimpleName());
	}
}
