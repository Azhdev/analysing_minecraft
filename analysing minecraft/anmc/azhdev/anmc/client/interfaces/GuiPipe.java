package azhdev.anmc.client.interfaces;

/**
 * 
 */

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import azhdev.anmc.blocks.tileEntities.tileEntityPipe;
import azhdev.anmc.client.Container.containerPipe;

public class GuiPipe extends GuiContainer{

	
	
	public GuiPipe(InventoryPlayer playerInv, tileEntityPipe pipe) {
		super(new containerPipe(playerInv, pipe));
		
		xSize = 176;
		ySize = 154;
	}

	private static ResourceLocation texture  = new ResourceLocation("anmc", "textures/gui/pipe.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);		
	}

}
