package azhdev.anmc;

import net.minecraft.world.gen.feature.WorldGenerator;
import azhdev.anmc.blocks.anmcBlocks;
import azhdev.anmc.entities.Entities;
import azhdev.anmc.generate.GenerateTreasureChest;
import azhdev.anmc.handlers.GenerationHandler;
import azhdev.anmc.handlers.GuiHandler;
import azhdev.anmc.items.anmcItems;
import azhdev.anmc.lib.Reference;
import azhdev.anmc.misc.CreativeTabAM;
import azhdev.anmc.misc.recipeInitializer;
import azhdev.anmc.proxies.CommonProxy;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class mainModClass{

	
	@Instance(Reference.MOD_ID)
	public static mainModClass instance;
	
	@SidedProxy(clientSide = "azhdev.anmc.proxies.ClientProxy", serverSide = "azhdev.anmc.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	WorldGenerator treasureChest = new GenerateTreasureChest();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		
		recipeInitializer.init();
		anmcBlocks.init();
		anmcItems.init();
		CreativeTabAM.initTab();
		anmcItems.setTab();
		anmcBlocks.setTab();
		anmcBlocks.registerTileEntities();
		
    	
    	GameRegistry.registerWorldGenerator((IWorldGenerator) treasureChest, 1);
		
		Entities.init();
		proxy.initRendering();
	}	
    @EventHandler
    public void init(FMLInitializationEvent event){

    	new GuiHandler();
    }
    
    @EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		
	}
}
