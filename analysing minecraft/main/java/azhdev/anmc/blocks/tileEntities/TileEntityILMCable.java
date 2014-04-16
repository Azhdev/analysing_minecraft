package azhdev.anmc.blocks.tileEntities;

import azhdev.anmc.Generic.TileEntityILGeneric;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.world.World;

public class TileEntityILMCable extends TileEntityILGeneric implements IInventory{

	/**
	* boolean[] for storing the connected sides
	* 0 = xPos
	* 1 = xNeg
	* 2 = zPos
	* 3 = zNeg
	* 4 = top
	* 5 = bottom
	*/
	private static boolean[] connectedSides;
	
	@Override
	public void updateEntity(){
		
	}
	
	@Override
	public void updateCable(World world, int x, int y, int z){
		boolean[] Sides = new boolean[6];
		if(world.getBlock(x + 1, y, z) instanceof IInventory || world.getBlock(x + 1, y, z) instanceof ISidedInventory){
			Sides[0] = true;
		}else{
			Sides[0] = false;
		}
		if(world.getBlock(x - 1, y, z) instanceof IInventory || world.getBlock(x - 1, y, z) instanceof ISidedInventory){
			Sides[1] = true;
		}else{
			Sides[1] = false;
		}
		if(world.getBlock(x, y, z + 1) instanceof IInventory || world.getBlock(x, y, z + 1) instanceof ISidedInventory){
			Sides[2] = true;
		}else{
			Sides[2] = false;
		}
		if(world.getBlock(x, y, z - 1) instanceof IInventory || world.getBlock(x, y, z - 1) instanceof ISidedInventory){
			Sides[3] = true;
		}else{
			Sides[3] = false;
		}
		if(world.getBlock(x, y + 1, z) instanceof IInventory || world.getBlock(x, y + 1, z) instanceof ISidedInventory){
			Sides[4] = true;
		}else{
			Sides[4] = false;
		}
		if(world.getBlock(x, y - 1, z) instanceof IInventory || world.getBlock(x, y - 1, z) instanceof ISidedInventory){
			Sides[5] = true;
		}else{
			Sides[5] = false;
		}
		setAttachedCables(Sides);
	}
	
	@Override
	public void setAttachedCables(boolean[] sides){
		for(int i = 0; i > 5; i++){
			connectedSides[i] = sides[i];
		}
	}
	
	@Override
	public boolean[] getConnectedSides(){
		return connectedSides;
	}
}
