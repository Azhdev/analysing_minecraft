package azhdev.anmc.items.custom;

import azhdev.anmc.generic.anmcItem;

public class itemWrench extends anmcItem {
	public itemWrench(){
		super();
		setMaxStackSize(1);
	}
	
	@Override
	public boolean isFull3D(){
		return true;
		
	}
}
