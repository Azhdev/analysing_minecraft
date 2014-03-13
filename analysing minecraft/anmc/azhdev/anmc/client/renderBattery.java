package azhdev.anmc.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import azhdev.anmc.client.models.ModelBattery;
import azhdev.anmc.entities.entityBattery;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class renderBattery extends Render{

	private ModelBattery model;
	
	public renderBattery(ModelBattery model){
		this.model = model;
		shadowSize = 0.5F;
	}
	
	public static final ResourceLocation texture = new ResourceLocation("anmc", "textures/models/battery.png");
	
	public void renderbattery(entityBattery batt, double x, double y, double z, float yaw, float partialTickTime){
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F, -1F, -1F);
		
		bindEntityTexture(batt);
		
		model.render(batt, 0, 0, 0, 0, 0, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		renderbattery((entityBattery)entity, x, y, z, yaw, partialTickTime);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
