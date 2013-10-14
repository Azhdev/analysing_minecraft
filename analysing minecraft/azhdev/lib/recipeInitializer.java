package lib;

import item.items;
//import anmc.alloyCraftingHandler;
import blocks.blockInfo;
import blocks.blocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipeInitializer {
	
	public static void shapedCraftingInit(){
		//add shaped recipes
		
		//items
		GameRegistry.addShapedRecipe(new ItemStack(items.plating, 4), new Object[]{"ICI", "CEC", "ICI", 'I', Item.ingotIron, 'C', items.ingotCenerium, 'E', items.ingotEtebrium});
		GameRegistry.addShapedRecipe(new ItemStack(items.plating, 4), new Object[]{"CIC", "IEI", "CIC", 'I', Item.ingotIron, 'C', items.ingotCenerium, 'E', items.ingotEtebrium});
		GameRegistry.addShapedRecipe(new ItemStack(items.large_plating, 4), new Object[]{"PIP", "IEI", "PIP", 'P', items.plating, 'I', Item.ingotIron, 'E', items.ingotEtebrium});
		GameRegistry.addShapedRecipe(new ItemStack(items.large_plating, 4), new Object[]{"IPI", "PEP", "IPI", 'P', items.plating, 'I', Item.ingotIron, 'E', items.ingotEtebrium});
		GameRegistry.addShapedRecipe(new ItemStack(items.magnifying,  1), new Object[]{"  G", " S ", "S  ", 'G', Block.glass, 'S', Item.stick});
		
		//blocks
		GameRegistry.addShapedRecipe(new ItemStack(blocks.Analyzer, 1), new Object[]{"LML" ,"PEP","LPL", 'L', items.large_plating, 'M', items.magnifying, 'E', items.ingotEdomium, 'P', items.plating});
	}
	
	public static void shapelessCraftingInit(){
		
	}
	
	public static void smeltingInit(){
		//add smelting recipes for the furnace etc.
		GameRegistry.addSmelting(blockInfo.CENERIUMORE_ID, new ItemStack(items.ingotCenerium), 2);
		GameRegistry.addSmelting(blockInfo.ETEBRIUMORE_ID, new ItemStack(items.ingotEtebrium), 2);
		GameRegistry.addSmelting(blockInfo.EDOMIUMORE_ID, new ItemStack(items.ingotEdomium), 2);
	}
	
	public static void alloySmeltingInit(){
		//alloyCraftingHandler.addAlloyrecipe(new ItemStack(items.ingotCremomium, 1));
	}
}
