package azhdev.anmc.Generic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AzhdevBlockContainer extends BlockContainer{

	protected AzhdevBlockContainer(Material mat) {
		super(mat);
		setHardness(2.0F);
		setBlockName(this.getClass().getSimpleName());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
		blockIcon = register.registerIcon("anmc:" + getClass().getSimpleName());
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

}
