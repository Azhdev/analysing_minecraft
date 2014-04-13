package azhdev.anmc.handlers;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import azhdev.anmc.items.anmcItems;

/**
 * 
 * InfuserCraftingHandler.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class InfuserCraftingHandler {
	
	private static int recipeListLenght = 0;
	
	private Item[] one = new Item[recipeListLenght];
	private Item[] two = new Item[recipeListLenght];
	private Item[] three = new Item[recipeListLenght];
	private ItemStack[] output = new ItemStack[recipeListLenght];
	
	public void addRecipe(ItemStack output, Item item1, Item item2, Item item3){
		recipeListLenght++;
		one[recipeListLenght] = item1;
		two[recipeListLenght] = item2;
		three[recipeListLenght] = item3;
		
	}	
	
	private Item getOutput(Item item1, Item item2, Item item3){		
		
		if(item1 == anmcItems.ingot && item2 == Items.iron_ingot && item3 == Items.gold_ingot || 
			item1 == anmcItems.ingot && item2 == Items.gold_ingot && item3 == Items.iron_ingot ||
			item1 == Items.iron_ingot && item2 == anmcItems.ingot && item3 == Items.gold_ingot ||
			item1 == Items.iron_ingot && item2 == Items.gold_ingot && item3 == anmcItems.ingot ||
			item1 == Items.gold_ingot && item2 == anmcItems.ingot && item3 == Items.iron_ingot ||
			item1 == Items.gold_ingot && item2 == Items.iron_ingot && item3 == anmcItems.ingot){
			return anmcItems.suckUpgrade;
		}else{
			return null;
		}
		
	}
}
