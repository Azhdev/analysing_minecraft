package azhdev.anmc.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class entityBattery extends Entity{

	private double startY;
	private double targetY;
	
	public entityBattery(World world) {
		super(world);
	}

	public entityBattery(World world, double x, double y, double z){
		this(world);
		posX = x;
		startY = posY = y;
		posZ = z;
	}
	
	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		startY = var1.getShort("start");
		targetY = var1.getShort("target");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		var1.setShort("start", (short)startY);
		var1.setShort("target", (short)targetY);
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		
		if(!worldObj.isRemote){
			if(targetY == 0 || Math.abs(posY - targetY) < 0.25){
				targetY = startY + worldObj.rand.nextDouble() * 5;
			}
			
			if(posY < targetY){
				motionY = 0.05;
			}else{
				motionY = -0.05;
			}
		}
		
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}
	
}
