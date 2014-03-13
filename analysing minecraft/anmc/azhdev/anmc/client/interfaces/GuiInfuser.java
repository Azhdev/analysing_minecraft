package azhdev.anmc.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import azhdev.anmc.blocks.tileEntities.TileEntityInfuser;
import azhdev.anmc.client.Container.ContainerInfuser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * GuiInfuser.java
 *
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

@SideOnly(Side.CLIENT)
public class GuiInfuser extends GuiContainer{

	public GuiInfuser(InventoryPlayer playerInv, TileEntityInfuser infuser) {
		
		super(new ContainerInfuser(playerInv, infuser));
		
		xSize = 176;
		ySize = 154;
	}

	private static ResourceLocation texture  = new ResourceLocation("anmc", "textures/gui/Infuser.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
}
