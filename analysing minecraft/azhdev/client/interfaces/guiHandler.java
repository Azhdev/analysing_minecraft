package client.interfaces;

import blocks.tileEntities.TileEntityAlloymaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import anmc.analysing_minecraft;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class guiHandler implements IGuiHandler{

	public guiHandler(){
		NetworkRegistry.instance().registerGuiHandler(analysing_minecraft.instance, this);
	
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		switch(ID){
		case 0:
				TileEntity te = world.getBlockTileEntity(x, y, z);
				if (te != null && te instanceof TileEntityAlloymaker){
					return new ContainerAlloymaker(player.inventory, (TileEntityAlloymaker)te);
				}
				break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		switch(ID){
		case 0:
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityAlloymaker){
				return new guiAlloymaker(player.inventory, (TileEntityAlloymaker)te);
			}
		}
		return null;
	}
	
}
