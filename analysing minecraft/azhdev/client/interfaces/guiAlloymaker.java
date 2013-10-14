package client.interfaces;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import blocks.tileEntities.TileEntityAlloymaker;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class guiAlloymaker extends GuiContainer{
	private ResourceLocation tif = new ResourceLocation("anmc", "textures/gui/alloymaker.png");
	private TileEntityAlloymaker inputFurnaceInventory;

	public guiAlloymaker(InventoryPlayer inventoryplayer, TileEntityAlloymaker tileentityAlloymaker)
	{
	         super(new ContainerAlloymaker(inventoryplayer, tileentityAlloymaker));
	         inputFurnaceInventory = tileentityAlloymaker;
	}
	/**
	         * Draw the foreground layer for the GuiContainer (everything in front of the items)
	         */
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
	         fontRenderer.drawString(StatCollector.translateToLocal("alloy furnace"), 40, 6, 0x404040);
	         fontRenderer.drawString(StatCollector.translateToLocal("Inventory"), 8, (ySize - 96) + 2, 0x404040);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}

}
