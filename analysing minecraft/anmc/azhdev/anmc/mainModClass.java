package azhdev.anmc;

import azhdev.anmc.blocks.anmcBlocks;
import azhdev.anmc.items.anmcItems;
import azhdev.anmc.lib.Reference;
import azhdev.anmc.lib.local;
import azhdev.anmc.misc.CreativeTabAM;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class mainModClass{

	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		anmcBlocks.init();
		anmcItems.init();
		CreativeTabAM.initTab();
		anmcItems.setTab();
		anmcBlocks.setTab();
	}	
    @EventHandler
    public void init(FMLInitializationEvent event){
    	anmcItems.addNames();
    	anmcBlocks.addNames();
    	local.fixNames();
    }
    
    @EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		
	}
}
