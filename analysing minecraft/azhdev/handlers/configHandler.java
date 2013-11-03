package handlers;


import java.io.File;

import net.minecraftforge.common.Configuration;
import blocks.blockInfo;
import item.itemInfo;


public class configHandler {
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		config.load();
		
		//block config
		blockInfo.ANALYSER_ID = config.getBlock(blockInfo.ANALYSER_TE_KEY, blockInfo.ANALYSER_DEFAULT).getInt();
		blockInfo.ALLOYMAKER_ID = config.getBlock(blockInfo.ALLOYMAKER_TE_KEY, blockInfo.ALLOYMAKER_DEFAULT).getInt();
		blockInfo.ALLOYMAKERACTIVE_ID = config.getBlock(blockInfo.ALLOYMAKERACTIVE_TE_KEY, blockInfo.ALLOYMAKERACTIVE_DEFAULT).getInt();
		blockInfo.CENERIUMORE_ID = config.getBlock(blockInfo.CENERIUMORE_KEY, blockInfo.CENERIUMORE_DEFAULT).getInt();
		blockInfo.ETEBRIUMORE_ID = config.getBlock(blockInfo.ETEBRIUMORE_KEY, blockInfo.ETEBRIUMORE_DEFAULT).getInt();
		blockInfo.EDOMIUMORE_ID = config.getBlock(blockInfo.EDOMIUMORE_KEY, blockInfo.EDOMIUMORE_DEFAULT).getInt();
		
		//item config
		itemInfo.magnifying_ID = config.getItem(itemInfo.magnifying_KEY, itemInfo.magnifying_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.plating_ID = config.getItem(itemInfo.plating_KEY, itemInfo.plating_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.largeplating_ID = config.getItem(itemInfo.largeplating_KEY, itemInfo.largeplating_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.ingotCenerium_ID = config.getItem(itemInfo.ingotCenerium_KEY, itemInfo.ingotCenerium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.ingotEtebrium_ID = config.getItem(itemInfo.ingotEtebrium_KEY, itemInfo.ingotEtebrium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.ingotEdomium_ID = config.getItem(itemInfo.ingotEdomium_KEY, itemInfo.ingotEdomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.ingotCremomium_ID = config.getItem(itemInfo.ingotCremomium_KEY, itemInfo.ingotCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.hatchetCremomium_ID = config.getItem(itemInfo.hatchetCremomium_KEY, itemInfo.hatchetCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.swordCremomium_ID = config.getItem(itemInfo.swordCremomium_KEY, itemInfo.swordCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.shovelCremomium_ID = config.getItem(itemInfo.shovelCremomium_KEY, itemInfo.shovelCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.hoeCremomium_ID = config.getItem(itemInfo.hoeCremomium_KEY, itemInfo.hoeCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.feetCremomium_ID = config.getItem(itemInfo.feetCremomium_KEY, itemInfo.feetCremomium_DEFAULT).getInt() - itemInfo.ID_correction;
		itemInfo.scroll_ID = config.getItem(itemInfo.scroll_KEY, itemInfo.scroll_DEFAULT).getInt() - itemInfo.ID_correction;
		
		//misc config
		
		config.save();
	}
}
