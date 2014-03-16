package azhdev.anmc.blocks.custom;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import azhdev.anmc.mainModClass;
import azhdev.anmc.blocks.tileEntities.TileEntityExtractPipe;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.items.anmcItems;
import azhdev.anmc.lib.GuiIDs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class extractPipe extends BlockContainer{

	public extractPipe(Material material) {
		super(material);
		setHardness(2.0F);
		setBlockName("extractPipe");
	}

	public void registerIcons(IIconRegister register){

		blockIcon = register.registerIcon("anmc:extractPipe");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityExtractPipe();
	}
	
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == anmcItems.wrench){
					FMLNetworkHandler.openGui(player, mainModClass.instance, GuiIDs.pipeExtractGuiID, world, x, y, z);
			}
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block , int meta){
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof IInventory){
			
			IInventory inventory = (IInventory)te;
			for(int i = 0; i < inventory.getSizeInventory(); i++){
				
				ItemStack stack = inventory.getStackInSlotOnClosing(i);
				if(stack != null){
					
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();
					
					
					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);
						
					float mult = 0.05F;
					
					droppedItem.motionX = (-0.5F + world.rand.nextFloat() * mult);
					droppedItem.motionY = (-0.5F + world.rand.nextFloat() * mult);
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat() * mult);
					
					world.spawnEntityInWorld(droppedItem);
					
					
				}
			}
		}
	}
	
	@Override
	public boolean onBlockEventReceived(World world, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_){
		return blockConstructorCalled;
		
	}
	
}
