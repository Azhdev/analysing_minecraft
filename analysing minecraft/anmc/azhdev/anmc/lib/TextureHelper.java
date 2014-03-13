package azhdev.anmc.lib;

import java.util.HashMap;

import azhdev.anmc.util.MachineType;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class TextureHelper {
	public static final TextureHelper instance = new TextureHelper();
	public static final String TEXTURE_LOC = Reference.TEXTURE_LOC;
	public static HashMap<Integer, String[]> machineTextureNames = new HashMap<Integer, String[]>();
	public static final String[] sides = {
		"top", "front", "frontOn", "side"
	};
	public static String[] getTextureNamesForType(MachineType machineType) {
		return machineTextureNames.get(machineType.ordinal());
	}
	public static void buildFurnaceTextureNames(){
		for(MachineType type : MachineType.values()){
			String[] names = new String[sides.length];
			for(int i = 0; i < names.length; i++)
				names[i] = String.format("%s_%s", type.name().toLowerCase(), sides[i]);
			machineTextureNames.put(type.ordinal(), names);
		}
	}
	public enum Side{
		BOTTOM(),
		TOP(),
		BACK(),
		FRONT(),
		LEFT(),
		RIGHT(),
	}

	public static final int BOTTOM = 0;
	public static final int TOP = 1;
	public static final int BACK = 2;
	public static final int FRONT = 3;
	public static final int RIGHT = 5;
	public static final int LEFT = 4;
}