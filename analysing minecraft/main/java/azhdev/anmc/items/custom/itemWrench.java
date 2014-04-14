package azhdev.anmc.items.custom;

import azhdev.anmc.Generic.AzhdevItem;

public class itemWrench extends AzhdevItem {
	public itemWrench(){
		super();
		setMaxStackSize(1);
	}
	
	@Override
	public boolean isFull3D(){
		return true;
		
	}
}
