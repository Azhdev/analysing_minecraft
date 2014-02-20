package azhdev.anmc.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import azhdev.anmc.mainModClass;
import azhdev.anmc.blocks.custom.CeneriumOre;
import azhdev.anmc.blocks.custom.EdomiumOre;
import azhdev.anmc.blocks.custom.EtebriumOre;
import azhdev.anmc.misc.CreativeTabAM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class anmcBlocks {
	
	public static Block CeneriumOre;
	public static Block EdomiumOre;
	public static Block EtebriumOre;
	
	public static void init(){
		CeneriumOre = new CeneriumOre();
		GameRegistry.registerBlock(CeneriumOre, "Cenerium ore");
		
		EdomiumOre = new EdomiumOre();
		GameRegistry.registerBlock(EdomiumOre, "EdomiumOre");
		
		EtebriumOre = new EtebriumOre();
		GameRegistry.registerBlock(EtebriumOre, "EtebriumOre");
	}
	public static void addNames(){

	}
	
	public static void registerTileEntities(){

	}
	
	public static void setTab(){
		CeneriumOre.setCreativeTab(CreativeTabAM.tabsAM);
		EdomiumOre.setCreativeTab(CreativeTabAM.tabsAM);
		EtebriumOre.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
