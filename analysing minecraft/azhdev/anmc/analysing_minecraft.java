package anmc;

import handlers.PacketHandler;
import handlers.configHandler;
import handlers.eventHandlerThingy;
import handlers.generationHandler;
import item.items;
import lib.Reference;
import lib.recipeInitializer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import proxies.CommonProxy;
import anmc.misc.CreativeTabAM;
import blocks.blocks;
import client.interfaces.guiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.channel }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class analysing_minecraft {

	public static CreativeTabs tabsAM = new CreativeTabAM(
			CreativeTabs.getNextID(), Reference.MOD_NAME);
	public static EnumToolMaterial Cremomium = EnumHelper.addToolMaterial("Cremomium", 2, 1500, 10.0F, 4, 22);
	public static EnumArmorMaterial CremomiumArmor = EnumHelper.addArmorMaterial("Cremomium", 15, new int[] { 2, 6, 5, 2 }, 9);

	@Instance(Reference.MOD_ID)
	public static analysing_minecraft instance;

	@SidedProxy(clientSide = "proxies.ClientProxy", serverSide = "proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		configHandler.init(event.getSuggestedConfigurationFile());
		blocks.init();
		items.init();
		blocks.registerTileEntities();
		proxy.initRendering();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		//add names to objects
		items.addNames();
		blocks.addNames();
		LanguageRegistry.instance().addStringLocalization("itemGroup.analysingminecraft", "en_US", "Analysing Minecraft");
		
		//add recipes for the mod
		recipeInitializer.shapedCraftingInit();
		recipeInitializer.shapelessCraftingInit();
		recipeInitializer.smeltingInit();
		recipeInitializer.alloySmeltingInit();
		

		//load eventhandler
		eventHandlerThingy eventHandlerThingy = new eventHandlerThingy();
		MinecraftForge.EVENT_BUS.register(eventHandlerThingy);

		//load generation handler
		new generationHandler();
		
		//load gui handler
		new guiHandler();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

	}
}
