package client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class guiScroll extends GuiContainer{
	public guiScroll(InventoryPlayer invplayer){
		super (new ContainerScroll());
		
		xSize = 256;
		ySize = 214;
	}

	private static final ResourceLocation texture = new ResourceLocation("anmc", "textures/gui/scrollGui.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
