package azhdev.anmc.handlers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import azhdev.anmc.blocks.anmcBlocks;
import azhdev.anmc.items.anmcItems;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class GenerationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
			generateChests(world, random, chunkX * 16, chunkZ *16);
			generateOres(world, random, chunkX * 16, chunkZ * 16);
	}
	
	private void generateOres(World world, Random random, int x, int z){
		this.addOreSpawn(anmcBlocks.CeneriumOre, world, random, x, z, 16, 16, 10, 6, 30, 60);
		this.addOreSpawn(anmcBlocks.EdomiumOre, world, random, x, z, 16, 16, 10, 6, 30, 60);
		this.addOreSpawn(anmcBlocks.EtebriumOre, world, random, x, z, 16, 16, 10, 6, 30, 60);
	}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos,
			 int maxX, int maxZ, int maxVeinSize, int chance, int minY, int maxY){
		
		assert maxY > minY : "The maximum must be greater than the minimum";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
        assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
        assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
        
        int YDiff = maxY - minY;
        for(int i = 0; i < chance; i++){
        	int posX = blockXPos + random.nextInt(maxX);
        	int posY = minY + random.nextInt(YDiff);
        	int posZ = blockZPos + random.nextInt(maxZ);
        	(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
	}
	
	private void generateChests(World world, Random random, int PosX,int PosZ){
		int x = PosX + random.nextInt(16);
		int y = 256;
		int z = PosZ + random.nextInt(16);
		while (world.isAirBlock(x, y, z) && y > 40){
            y--;
        }
        if(random.nextInt(500) == 12){
        	world.setBlock(x, y + 1, z, Blocks.chest);
        	TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y + 1, z);
        	chest.setInventorySlotContents(14, new ItemStack(anmcItems.upgrade, 5));
        	if(random.nextInt(100) == 50){
        		chest.setInventorySlotContents(13, new ItemStack(anmcItems.treasureMap));
        	}
            System.out.println("[anmc] chest spawned at: " + x + ", " + y + ", " + z);
        }else{
        	return;
        }
	}	
}
