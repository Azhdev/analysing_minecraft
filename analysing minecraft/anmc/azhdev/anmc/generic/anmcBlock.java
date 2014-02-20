package azhdev.anmc.generic;

import azhdev.anmc.misc.CreativeTabAM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class anmcBlock extends Block {

	public anmcBlock(Material material) {
		super(material);
		setCreativeTab(CreativeTabAM.tabsAM);
	}
	
	
	public void registerIcons(IIconRegister register){
		blockIcon = register.registerIcon("anmc:blockOreAnmc");
	}
}
