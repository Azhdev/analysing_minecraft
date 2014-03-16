package azhdev.anmc.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import azhdev.anmc.items.custom.itemWrench;
import azhdev.anmc.items.custom.suckUpgrade;
import azhdev.anmc.items.custom.tempItem;
import azhdev.anmc.items.custom.treasureMap;
import azhdev.anmc.items.custom.anmcIngot;
import azhdev.anmc.items.custom.speedUpgrade;
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
	public static Item wrench;
	public static Item temp;
	public static Item upgrade;
	public static Item suckUpgrade;
	
	public static void init(){
		treasureMap = new treasureMap();
		GameRegistry.registerItem(treasureMap, "treasureMap");
		ingot = new anmcIngot();
		GameRegistry.registerItem(ingot, "anmcIngot");
		wrench = new itemWrench();
		GameRegistry.registerItem(wrench, "wrench");
		//temp = new tempItem();
		//GameRegistry.registerItem(temp, "temp");
		upgrade = new speedUpgrade();
		GameRegistry.registerItem(upgrade, "Upgrade");
		suckUpgrade = new suckUpgrade();
		GameRegistry.registerItem(suckUpgrade, "suckUpgrade");
	}
	
	public static void addNames(){
		
	}
	
	public static void setTab(){
		treasureMap.setCreativeTab(CreativeTabAM.tabsAM);
		ingot.setCreativeTab(CreativeTabAM.tabsAM);
		wrench.setCreativeTab(CreativeTabAM.tabsAM);
		upgrade.setCreativeTab(CreativeTabAM.tabsAM);
		suckUpgrade.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
