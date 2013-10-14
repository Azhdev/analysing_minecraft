package blocks.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnalyzer extends TileEntity{
	
	private int timer = 100;
	public TileEntityAnalyzer() {
		timer = 100;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
	}
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
	}
	

	
	@Override
	public void updateEntity(){
		timer--;
	}
	
	public boolean isIdle(){
		return timer < 0;
	}
	/**
	private boolean inAnalyzer = false;
	
	public boolean InAnalyzer(boolean inAnalyzer){
		if(slot1.itemID == itemInfo.magnifying_ID){
			inAnalyzer = true;
		}else{
			inAnalyzer = false;
		}
	}
	*/
}
