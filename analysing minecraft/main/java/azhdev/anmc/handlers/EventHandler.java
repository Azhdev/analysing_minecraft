package azhdev.anmc.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class EventHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 0:
			generateOverworld(world, random, chunkX * 16, chunkZ *16);
		}
	}

	private void generateOverworld(World world, Random random, int i, int j) {
		
	}

}
