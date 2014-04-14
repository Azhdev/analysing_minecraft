package azhdev.anmc.misc;

import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public interface ExtractorPipe extends IInventory {
	
	World getWorldObj();
	
	double getXpos();
	
	double getYpos();
	
	double getZpos();
}
