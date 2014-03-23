package azhdev.anmc.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import azhdev.anmc.mainModClass;
import azhdev.anmc.blocks.tileEntities.TileEntityExtractPipe;
import azhdev.anmc.items.anmcItems;
import azhdev.anmc.lib.GuiIDs;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	
	
	@SideOnly(Side.CLIENT)
	private IIcon inputIcon;
	private IIcon outputIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){

		blockIcon = register.registerIcon("anmc:pipeNeutral");
		inputIcon = register.registerIcon("anmc:pipeInput");
		outputIcon = register.registerIcon("anmc:pipeOutput");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		return blockIcon;
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityExtractPipe();
	}
	
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9){
        int facing = Facing.oppositeSide[par5];

        if (facing == 1)
        {
            facing = 0;
        }

        return facing;
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
        super.onBlockAdded(world, x, y, z);
        this.updateMetadata(world, x, y, z);
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == anmcItems.wrench){
					FMLNetworkHandler.openGui(player, mainModClass.instance, GuiIDs.pipeExtractGuiID, world, x, y, z);
			}
		}
		return false;
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

	public static boolean getIsBlockNotPoweredFromMetadata(int blockMetadata) {
	        return (blockMetadata & 8) != 8;
	}


	public static int getDirectionFromMetadata(int blockMetadata) {
		return blockMetadata & 7;
	}
	
	
	private void updateMetadata(World world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
        int direction = getDirectionFromMetadata(meta);
        boolean powered = !world.isBlockIndirectlyGettingPowered(x, y, z);
        boolean notpowered = getIsBlockNotPoweredFromMetadata(meta);

        if (powered != notpowered){
            world.setBlockMetadataWithNotify(x, y, z, direction | (powered ? 0 : 8), 4);
        }
    }
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		this.updateMetadata(world, x, y, z);
	}
}