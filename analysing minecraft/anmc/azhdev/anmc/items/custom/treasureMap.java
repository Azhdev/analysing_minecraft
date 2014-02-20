package azhdev.anmc.items.custom;

import azhdev.anmc.generic.anmcItem;
import azhdev.anmc.items.anmcItems;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import azhdev.anmc.misc.CreativeTabAM;

/**
 * 
 * @author azhdev
 *
 */

public class treasureMap extends anmcItem{
	
	public treasureMap() {
		super();
		setUnlocalizedName("treasureMap");
		setInfo("rightClick for a suprise");
	}
	private Boolean firstUse;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	NBTTagCompound compound = new NBTTagCompound();
	
	private void setUse(Boolean use) {
		NBTTagList nbttaglist1 = compound.getTagList("use", 1);
		compound.setBoolean("firstUseOrNot", use);
	}
	
	private Boolean getUse(){
		NBTTagList nbttaglist = compound.getTagList("use", 1);
        firstUse = compound.getBoolean("firstUseOrNot");
        return firstUse;
    }
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		int playerPosX = (int) player.posX;
		int playerPosZ = (int) player.posZ; 
		Random Coord = new Random();
		xCoord = Coord.nextInt(20) + playerPosX;
		yCoord = Coord.nextInt(40);
		zCoord = Coord.nextInt(20) + playerPosZ;
		//if(getUse()){
			ItemStack anmcIngot = new ItemStack(anmcItems.ingot);
			world.setBlock(xCoord, yCoord, zCoord, Block.getBlockFromName("minecraft:chest"));
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(xCoord, yCoord, zCoord);
			if(chest != null){
				chest.setInventorySlotContents(15, anmcIngot);
			}
			//setUse(false);
		//}else{
			//System.out.println("already used");
			//return false;
		//}
		return false;
    }
	       
}
