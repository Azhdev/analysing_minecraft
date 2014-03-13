package azhdev.anmc.entities;

import azhdev.anmc.mainModClass;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class Entities {
	
	public static void init(){
		EntityRegistry.registerModEntity(entityBattery.class, "battery", 0, mainModClass.instance, 80, 3, true);
	}
}
