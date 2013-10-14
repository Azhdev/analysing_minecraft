package blocks;

import blocks.machines.Alloymaker;
import blocks.machines.Analyzer;
import blocks.machines.blockPowerer;
import blocks.ores.CeneriumOre;
import blocks.ores.EdomiumOre;
import blocks.ores.EtebriumOre;
import blocks.tileEntities.TileEntityAlloymaker;
import blocks.tileEntities.TileEntityAnalyzer;
import blocks.tileEntities.tileEntityPowerer;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class blocks {

	public static Block Analyzer;
	public static Block Alloymaker;
	public static Block Powerer;
	public static Block CeneriumOre;
	public static Block EtebriumOre;
	public static Block EdomiumOre;
	
	public static void init(){
		
		Analyzer = new Analyzer(blockInfo.ANALYSER_ID);
		GameRegistry.registerBlock(Analyzer, blockInfo.ANALYSER_TE_KEY);
		
		Alloymaker = new Alloymaker(blockInfo.ALLOYMAKER_ID);
		GameRegistry.registerBlock(Alloymaker, blockInfo.ALLOYMAKER_TE_KEY);
		
		CeneriumOre = new CeneriumOre(blockInfo.CENERIUMORE_ID);
		GameRegistry.registerBlock(CeneriumOre, blockInfo.CENERIUMORE_KEY);
		
		EtebriumOre = new EtebriumOre(blockInfo.ETEBRIUMORE_ID);
		GameRegistry.registerBlock(EtebriumOre, blockInfo.ETEBRIUMORE_KEY);
		
		EdomiumOre = new EdomiumOre(blockInfo.EDOMIUMORE_ID);
		GameRegistry.registerBlock(EdomiumOre, blockInfo.EDOMIUMORE_KEY);
		
		Powerer = new blockPowerer(blockInfo.POWERER_ID, blockInfo.MACHINE_MATERIAL);
		GameRegistry.registerBlock(Powerer, blockInfo.POWERER_TE_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(CeneriumOre, blockInfo.CENERIUMORE_NAME);
		LanguageRegistry.addName(EtebriumOre, blockInfo.ETEBRIUMORE_NAME);
		LanguageRegistry.addName(EdomiumOre, blockInfo.EDOMIUMORE_NAME);
		LanguageRegistry.addName(Alloymaker, blockInfo.ALLOYMAKER_NAME);
		LanguageRegistry.addName(Analyzer, blockInfo.ANALYSER_TE_NAME);
		LanguageRegistry.addName(Powerer, blockInfo.POWERER_NAME);
	}
	
	public static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityAnalyzer.class, blockInfo.ANALYSER_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityAlloymaker.class, blockInfo.ALLOYMAKER_TE_KEY);
		GameRegistry.registerTileEntity(tileEntityPowerer.class, blockInfo.POWERER_TE_KEY);
	}
}
