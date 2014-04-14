package azhdev.anmc.generate;

import java.util.Random;

import azhdev.anmc.items.anmcItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateTreasureChest extends WorldGenerator implements IWorldGenerator{
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int y = 256;
		int x = random.nextInt(2000);
		int z = random.nextInt(2000);
		while (world.isAirBlock(x, y, z) && y > 40){
            y--;
        }
		if(world.getBlock(x, y, z) == Blocks.water || world.getBlock(x, y, z) == Blocks.waterlily || world.getBlock(x, y, z) == Blocks.ice){
			return;
		}
        if(random.nextInt(500) != 12){
        	world.setBlock(x, y + 1, z, Blocks.chest);
        	TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y + 1, z);
        	chest.setInventorySlotContents(4, new ItemStack(anmcItems.upgrade, 1));
        	chest.setInventorySlotContents(12, new ItemStack(anmcItems.upgrade, 1));
        	chest.setInventorySlotContents(14, new ItemStack(anmcItems.upgrade, 1));
        	chest.setInventorySlotContents(21, new ItemStack(anmcItems.upgrade, 1));
        	chest.setInventorySlotContents(23, new ItemStack(anmcItems.upgrade, 1));
        	if(random.nextInt(100) == 50){
        		chest.setInventorySlotContents(13, new ItemStack(anmcItems.treasureMap));
        	}
            System.out.println("[anmc] chest spawned at: " + x + ", " + y + ", " + z);
        }else{
        	return;
        }		
	}

	@Override
	public boolean generate(World var1, Random var2, int var3, int var4,
			int var5) {
		// TODO Auto-generated method stub
		return false;
	}
}
