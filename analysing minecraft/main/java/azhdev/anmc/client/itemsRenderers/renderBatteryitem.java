package azhdev.anmc.client.itemsRenderers;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import azhdev.anmc.client.renderBattery;
import azhdev.anmc.client.models.ModelBattery;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class renderBatteryitem implements IItemRenderer{

	private ModelBattery model;
	
	public renderBatteryitem(ModelBattery model){
		this.model = model;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		
		GL11.glScalef(-1F, -1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(renderBattery.texture);
		
		model.render(null, 0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
		
	}

}
