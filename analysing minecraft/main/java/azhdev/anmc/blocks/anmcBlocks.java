package azhdev.anmc.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import azhdev.anmc.mainModClass;
import azhdev.anmc.blocks.custom.BlockILMCable;
import azhdev.anmc.blocks.custom.CeneriumOre;
import azhdev.anmc.blocks.custom.EdomiumOre;
import azhdev.anmc.blocks.custom.EtebriumOre;
import azhdev.anmc.blocks.custom.ILMBlock;
import azhdev.anmc.blocks.custom.InfuserBlock;
import azhdev.anmc.blocks.custom.Pipe;
import azhdev.anmc.blocks.custom.battery;
import azhdev.anmc.blocks.custom.extractPipe;
import azhdev.anmc.blocks.tileEntities.TileEntityInfuser;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.misc.CreativeTabAM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014� Azhdev
 *
 */

public class anmcBlocks {
	
	public static Block CeneriumOre;
	public static Block EdomiumOre;
	public static Block EtebriumOre;
	public static Block Pipe;
	public static Block extractPipe;
	public static Block battery;
	public static Block infuser;
	public static Block ILM;
	public static Block ILMCable;
	
	public static void init(){
		CeneriumOre = new CeneriumOre();
		GameRegistry.registerBlock(CeneriumOre, "Cenerium ore");
		
		EdomiumOre = new EdomiumOre();
		GameRegistry.registerBlock(EdomiumOre, "EdomiumOre");
		
		EtebriumOre = new EtebriumOre();
		GameRegistry.registerBlock(EtebriumOre, "EtebriumOre");
		
		battery = new battery(Material.iron);
		GameRegistry.registerBlock(battery, "battery");
		
		infuser = new InfuserBlock(Material.iron);
		GameRegistry.registerBlock(infuser, "infuser");
		
		Pipe = new Pipe(Material.iron);
		GameRegistry.registerBlock(Pipe, "pipe");
		
		extractPipe = new extractPipe(Material.iron);
		GameRegistry.registerBlock(extractPipe, "extract");
		
		ILM = new ILMBlock(Material.iron);
		GameRegistry.registerBlock(ILM, "ILM");
		
		ILMCable = new BlockILMCable(Material.iron);
		GameRegistry.registerBlock(ILMCable, "ILM cable");
	}
	
	public static void registerTileEntities(){
		GameRegistry.registerTileEntity(tileEntityPipe.class, "Pipe");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
	}
	
	public static void setTab(){
		CeneriumOre.setCreativeTab(CreativeTabAM.tabsAM);
		EdomiumOre.setCreativeTab(CreativeTabAM.tabsAM);
		EtebriumOre.setCreativeTab(CreativeTabAM.tabsAM);
		Pipe.setCreativeTab(CreativeTabAM.tabsAM);
		extractPipe.setCreativeTab(CreativeTabAM.tabsAM);
		battery.setCreativeTab(CreativeTabAM.tabsAM);
		infuser.setCreativeTab(CreativeTabAM.tabsAM);
	}
}
