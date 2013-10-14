package item;


import item.custom.Plating;
import item.custom.feetCremomium;
import item.custom.hatchetCremomium;
import item.custom.hoeCremomium;
import item.custom.large_plating;
import item.custom.magnifying;
import item.custom.shovelCremomium;
import item.custom.swordCremomium;
import item.ingots.ingotCenerium;
import item.ingots.ingotCremomium;
import item.ingots.ingotEdomium;
import item.ingots.ingotEtebrium;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import anmc.analysing_minecraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class items {
	
	public static Item magnifying;
	public static Item plating;
	public static Item large_plating;
	public static Item ingotCenerium;
	public static Item ingotEtebrium;
	public static Item ingotEdomium;
	public static Item ingotCremomium;
	public static Item hatchetCremomium;
	public static Item swordCremomium;
	public static Item shovelCremomium;
	public static Item hoeCremomium;
	public static Item feetcremomium;
	public static Item trousersCremomium;
	
	public static void init() {
		
		magnifying = new magnifying(itemInfo.magnifying_ID);
		plating = new Plating(itemInfo.plating_ID);
		large_plating = new large_plating(itemInfo.largeplating_ID);
		ingotCenerium = new ingotCenerium(itemInfo.ingotCenerium_ID);
		ingotEtebrium = new ingotEtebrium(itemInfo.ingotEtebrium_ID);
		ingotEdomium = new ingotEdomium(itemInfo.ingotEdomium_ID);
		ingotCremomium = new ingotCremomium(itemInfo.ingotCremomium_ID);
		hatchetCremomium = new hatchetCremomium(itemInfo.hatchetCremomium_ID, analysing_minecraft.Cremomium);
		swordCremomium = new swordCremomium(itemInfo.swordCremomium_ID, analysing_minecraft.Cremomium);
		shovelCremomium = new shovelCremomium(itemInfo.shovelCremomium_ID, analysing_minecraft.Cremomium);
		hoeCremomium = new hoeCremomium(itemInfo.hoeCremomium_ID, analysing_minecraft.Cremomium);
		feetcremomium = new feetCremomium(itemInfo.feetCremomium_ID, analysing_minecraft.CremomiumArmor, itemInfo.renderCremomium,  3);
		//trousersCremomium = new trousersCremomium(itemInfo.feetCremomium_ID, analysing_minecraft.CremomiumArmor, itemInfo.renderCremomium,  2);
	}
	public static void addNames(){

		LanguageRegistry.addName(magnifying, itemInfo.magnifying_NAME);
		LanguageRegistry.addName(plating, itemInfo.plating_NAME);
		LanguageRegistry.addName(large_plating, itemInfo.largeplating_NAME);
		LanguageRegistry.addName(ingotCenerium, itemInfo.ingotCenerium_NAME);
		LanguageRegistry.addName(ingotEtebrium, itemInfo.ingotEtebrium_NAME);
		LanguageRegistry.addName(ingotEdomium, itemInfo.ingotEdomium_NAME);
		LanguageRegistry.addName(ingotCremomium, itemInfo.ingotCremomium_NAME);
		LanguageRegistry.addName(hatchetCremomium, itemInfo.hatchetCremomium_NAME);
		LanguageRegistry.addName(swordCremomium, itemInfo.swordcremomium_NAME);
		LanguageRegistry.addName(feetcremomium, itemInfo.feetCremomium_NAME);
		//LanguageRegistry.addName(trousersCremomium, itemInfo.trousersCremomium_NAME);
	}
	public static void loadRecipes(){
		GameRegistry.addRecipe(new ItemStack(hatchetCremomium, 1), new Object[] {"CC ", "CS ", " S ", 'C', ingotCremomium, 'S', Item.stick});
	}
}
