package azhdev.anmc.blocks.custom;

import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EtebriumOre extends BlockOre {

	public EtebriumOre() {
		super();
		this.setBlockName("Etebrium Ore");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("anmc:EtebriumOre");
	}
}