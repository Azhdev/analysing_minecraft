package blocks.tileEntities;

import net.minecraft.tileentity.TileEntity;

public class tileEntityPowerer extends TileEntity {
	
	@Override
	public void updateEntity(){
		System.out.println(TileEntityAlloymaker.progress);
		TileEntityAlloymaker.progress++;
    }
	
}
