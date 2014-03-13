package azhdev.anmc.util;

import javax.swing.Icon;

import azhdev.anmc.blocks.tileEntities.TileEntityInfuser;
import azhdev.anmc.blocks.tileEntities.TileEntityMachine;
import azhdev.anmc.lib.Reference;
import azhdev.anmc.lib.TextureHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public enum MachineType {
	BASE(TileEntityMachine.class, new String[]{}, -1),
	FURNACE(TileEntityInfuser.class, new String[]{ "decrementValue", "material" }, Reference.GUI_ID++);

	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	public Class<? extends TileEntity> theMachine;
	public String[] modifiers;
	public int guiID;
	public int tileType;

	MachineType(Class<? extends TileEntity> tileClass, String[] modifiers, int guiid){
		theMachine = tileClass;
		guiID = guiid;
		tileType = this.ordinal();
		this.modifiers = modifiers;
	}

	public void makeIcons(IIconRegister register){
		icons = new Icon[4];
		int counter = 0;
		String[] names = TextureHelper.getTextureNamesForType(this);
		for(String str : names)
			icons[counter++] = (Icon) register.registerIcon(String.format("%s:%s", TextureHelper.TEXTURE_LOC, str));
	}

	public Icon getIconBySide(int side, int dir, boolean isActive){
		if(dir == 0 || dir == 3){
			switch(side){
			case TextureHelper.TOP:   return icons[0];
			case TextureHelper.BOTTOM:return icons[0];
			case TextureHelper.FRONT: return icons[1];
			default: return icons[3];
			}
		}else if(dir == 2){
			 if(side == TextureHelper.BACK)
				return icons[isActive ? 2:1];
		}else if(dir == 5){
			if(side == TextureHelper.RIGHT)
				return icons[isActive ? 2:1];
		}else if(dir == 4){
			if(side == TextureHelper.LEFT)
				return icons[isActive ? 2:1];
		}
		switch(side){
		case TextureHelper.TOP:   return icons[0];
		case TextureHelper.BOTTOM:return icons[0];
		default: return icons[3];
		}
	}

	public static TileEntity makeTileEntity(int meta) {
		if(meta < values().length){
			try{
				TileEntity machine = values()[meta].theMachine.newInstance();
				return machine;
			}catch(Exception ex){
				//You did it wrong!
				ex.printStackTrace();
			}
		}
		return null;
	}
}