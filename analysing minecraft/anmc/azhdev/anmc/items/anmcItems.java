package azhdev.anmc.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import azhdev.anmc.items.custom.treasureMap;
import azhdev.anmc.items.custom.anmcIngot;
import azhdev.anmc.misc.CreativeTabAM;

public class anmcItems {
	public static Item treasureMap;
	public static Item ingot;
	
	public static void init(){
		treasureMap = new treasureMap();
		GameRegistry.registerItem(treasureMap, "treasureMap");
		ingot = new anmcIngot();
		GameRegistry.registerItem(ingot, "anmcIngot");
	}
	
	public static void addNames(){
		LanguageRegistry.addName(treasureMap, "Treasuremap");
		LanguageRegistry.addName(ingot, "ingot");
	}
	
	public static void setTab(){
		treasureMap.setCreativeTab(CreativeTabAM.tabsAM);
		ingot.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
