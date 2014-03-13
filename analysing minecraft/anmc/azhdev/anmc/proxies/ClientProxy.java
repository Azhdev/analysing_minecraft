package azhdev.anmc.proxies;

import net.minecraftforge.client.MinecraftForgeClient;
import azhdev.anmc.client.renderBattery;
import azhdev.anmc.client.itemsRenderers.renderBatteryitem;
import azhdev.anmc.client.models.ModelBattery;
import azhdev.anmc.entities.entityBattery;
import azhdev.anmc.items.anmcItems;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class ClientProxy extends CommonProxy {
	
	
	@Override
	public void initRendering() {
		ModelBattery model = new ModelBattery();
			RenderingRegistry.registerEntityRenderingHandler(entityBattery.class, new renderBattery(model));
			MinecraftForgeClient.registerItemRenderer(anmcItems.temp, new renderBatteryitem(model));
	}
}
