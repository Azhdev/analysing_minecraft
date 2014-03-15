package azhdev.anmc.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import azhdev.anmc.items.custom.tempItem;
import azhdev.anmc.items.custom.treasureMap;
import azhdev.anmc.items.custom.anmcIngot;
import azhdev.anmc.items.custom.anmcHammer;
import azhdev.anmc.items.custom.upgradeItem;
import azhdev.anmc.misc.CreativeTabAM;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class anmcItems {
	public static Item treasureMap;
	public static Item ingot;
	public static Item hammer;
	public static Item temp;
	public static Item upgrade;
	
	public static void init(){
		treasureMap = new treasureMap();
		GameRegistry.registerItem(treasureMap, "treasureMap");
		ingot = new anmcIngot();
		GameRegistry.registerItem(ingot, "anmcIngot");
		hammer = new anmcHammer();
		GameRegistry.registerItem(hammer, "hammer");
		//temp = new tempItem();
		//GameRegistry.registerItem(temp, "temp");
		upgrade = new upgradeItem();
		GameRegistry.registerItem(upgrade, "Upgrade");
	}
	
	public static void addNames(){
		
	}
	
	public static void setTab(){
		treasureMap.setCreativeTab(CreativeTabAM.tabsAM);
		ingot.setCreativeTab(CreativeTabAM.tabsAM);
		hammer.setCreativeTab(CreativeTabAM.tabsAM);
		upgrade.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
