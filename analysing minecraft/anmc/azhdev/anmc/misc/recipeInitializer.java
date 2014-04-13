package azhdev.anmc.misc;

import azhdev.anmc.items.anmcItems;
import azhdev.anmc.items.custom.speedUpgrade;
import azhdev.anmc.lib.Reference;
import azhdev.anmc.util.Log;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class recipeInitializer {
	
	public static void init(){
		addVanillaRecipes();
		addInfuserRecipes();
	}
	
	private static void addVanillaRecipes(){
		
	}
	
	
	private static void addInfuserRecipes(){
		InfuserRecipes.addRecipe(anmcItems.ingot, Items.iron_ingot, Items.gold_ingot, new ItemStack(anmcItems.upgrade, 1));
		Log.addInfo("added recipe: cenerium + iron + gold = speed upgrade");
	}
}
