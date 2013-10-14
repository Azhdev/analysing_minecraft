package blocks.machines;

import blocks.blockInfo;
import blocks.tileEntities.TileEntityAlloymaker;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import anmc.analysing_minecraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Alloymaker extends BlockContainer {

	public Alloymaker(int ID) {
		super(ID, blockInfo.MACHINE_MATERIAL);
		setCreativeTab(analysing_minecraft.tabsAM);
	}

	@Override
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(blockInfo.TEXTURELOCATION + ":" + blockInfo.ALLOYMAKER_SIDE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAlloymaker();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (world.isRemote){
        	FMLNetworkHandler.openGui(player, analysing_minecraft.instance, 0, world, x, y, z);
            return true;
        }
		return true;
	}
}

