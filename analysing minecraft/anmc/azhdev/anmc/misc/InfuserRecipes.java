package azhdev.anmc.misc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 
 *InfuserRecipes.java
 *
 * @author Azhdev
 *
 * copyright 2014 Azhdev
 */

public class InfuserRecipes {
	
	private static Item[] comp1;
	private static Item[] comp2;
	private static Item[] comp3;
	private static ItemStack[] result;
	private static int recipeNumber = 0; 
	
	public static ItemStack getResult(Item input1, Item input2, Item input3){
		if(input1 == null || input2 == null || input3 == null){
			return null;
		}
		for(int i = 0; i > recipeNumber; i++){
			if(input1 == comp1[i] && input2 == comp2[i] && input3 == comp3[i]){
				return result[i];
			}
		}
		return null;
	}
	
	private static int getNextrecipeID(){
		return recipeNumber + 1;
	}
	
	/**
	 * 
	 * adds a recipe to the database
	 * 
	 * @param Item input1 the, first item in the recipe (slot 0)
	 * @param Item input2 the, second item in the recipe (slot 1)
	 * @param Item input3 the, third item in the recipe (slot 2)
	 * @param ItemStack output, the output of the recipe
	 */
	public static void addRecipe(Item input1,Item input2, Item input3, ItemStack output){
		int recipeID = getNextrecipeID();
		if(input1 == null || input2 == null || input3 == null || output == null || recipeID == 0){
			return;
		}else{
			comp1[recipeID] = input1;
			comp2[recipeID] = input2;
			comp3[recipeID] = input3;
			result[recipeID] = output;
			recipeNumber++;
		}
	}
	
	
}