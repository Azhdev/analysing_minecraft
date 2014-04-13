package azhdev.anmc.items;

import net.minecraft.item.Item;
import azhdev.anmc.items.custom.ItemBattery;
import azhdev.anmc.items.custom.anmcIngot;
import azhdev.anmc.items.custom.itemWrench;
import azhdev.anmc.items.custom.speedUpgrade;
import azhdev.anmc.items.custom.suckUpgrade;
import azhdev.anmc.items.custom.treasureMap;
import azhdev.anmc.misc.CreativeTabAM;
import cpw.mods.fml.common.registry.GameRegistry;

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
	public static Item upgrade;
	public static Item suckUpgrade;
	public static Item itemBattery;
	
	public static void init(){
		treasureMap = new treasureMap();
		GameRegistry.registerItem(treasureMap, "treasureMap");
		ingot = new anmcIngot();
		GameRegistry.registerItem(ingot, "anmcIngot");
		wrench = new itemWrench();
		GameRegistry.registerItem(wrench, "wrench");
		upgrade = new speedUpgrade();
		GameRegistry.registerItem(upgrade, "Upgrade");
		suckUpgrade = new suckUpgrade();
		GameRegistry.registerItem(suckUpgrade, "suckUpgrade");
		itemBattery = new ItemBattery();
		GameRegistry.registerItem(itemBattery, "itembattery");		
	}
	
	public static void setTab(){
		treasureMap.setCreativeTab(CreativeTabAM.tabsAM);
		ingot.setCreativeTab(CreativeTabAM.tabsAM);
		wrench.setCreativeTab(CreativeTabAM.tabsAM);
		upgrade.setCreativeTab(CreativeTabAM.tabsAM);
		suckUpgrade.setCreativeTab(CreativeTabAM.tabsAM);
		itemBattery.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
