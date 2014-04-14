package azhdev.anmc.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import azhdev.anmc.mainModClass;
import azhdev.anmc.blocks.tileEntities.TileEntityExtractPipe;
import azhdev.anmc.blocks.tileEntities.TileEntityInfuser;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.client.Container.ContainerInfuser;
import azhdev.anmc.client.Container.ContainerPipe;
import azhdev.anmc.client.Container.containerExtractPipe;
import azhdev.anmc.client.interfaces.GuiExtractPipe;
import azhdev.anmc.client.interfaces.GuiInfuser;
import azhdev.anmc.client.interfaces.GuiPipe;
import azhdev.anmc.lib.GuiIDs;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class GuiHandler  implements IGuiHandler{

	public GuiHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(mainModClass.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GuiIDs.infuserGuiID){
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityInfuser){
				return new ContainerInfuser(player.inventory, (TileEntityInfuser)te);
			}
		}else if(ID == GuiIDs.pipeExtractGuiID){
			TileEntityExtractPipe te = (TileEntityExtractPipe)world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityExtractPipe){
				return new containerExtractPipe(player.inventory, (TileEntityExtractPipe)te);
			}
		}else if(ID == GuiIDs.pipeGuiID){
			tileEntityPipe pipe = (tileEntityPipe)world.getTileEntity(x, y, z);
			if(pipe != null && pipe instanceof tileEntityPipe){
				return new ContainerPipe(player.inventory, (tileEntityPipe)pipe);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == GuiIDs.infuserGuiID){
			TileEntity te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityInfuser){
				return new GuiInfuser(player.inventory, (TileEntityInfuser)te);
			}
		}else if(ID == GuiIDs.pipeGuiID){
			tileEntityPipe te = (tileEntityPipe)world.getTileEntity(x, y, z);
			if(te != null && te instanceof tileEntityPipe){
				return new GuiPipe(player.inventory, (tileEntityPipe)te);
			}
		}else if(ID == GuiIDs.pipeExtractGuiID){
			TileEntityExtractPipe pipe = (TileEntityExtractPipe)world.getTileEntity(x, y, z);
			if(pipe != null && pipe instanceof TileEntityExtractPipe){
				return new GuiExtractPipe(player.inventory, (TileEntityExtractPipe)pipe);
			}
		}
		
		return null;
	}

}
