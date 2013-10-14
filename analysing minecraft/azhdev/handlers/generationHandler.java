package handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import blocks.blockInfo;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class generationHandler implements IWorldGenerator {

	private WorldGenerator cenGen;
	private WorldGenerator eteGen;
	private WorldGenerator edoGen;
	
	public generationHandler(){
		GameRegistry.registerWorldGenerator(this);
		cenGen = new WorldGenMinable(blockInfo.CENERIUMORE_ID, 6);
		eteGen = new WorldGenMinable(blockInfo.ETEBRIUMORE_ID, 6);
		edoGen = new WorldGenMinable(blockInfo.EDOMIUMORE_ID, 6);
	}
	
	private void generateStandardOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY){
		for (int i = 0; i < iterations; i++){
			int x = chunkX * 16 + rand.nextInt(6);
			int y = rand.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ * 16 + rand.nextInt(6);
			
			gen.generate(world, rand, x, y, z);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		generateStandardOre(random, chunkX, chunkZ, world, 25, cenGen, 0, 40);
		generateStandardOre(random, chunkX, chunkZ, world, 25, eteGen, 0, 40);
		generateStandardOre(random, chunkX, chunkZ, world, 25, edoGen, 0, 40);
	}
	
}
