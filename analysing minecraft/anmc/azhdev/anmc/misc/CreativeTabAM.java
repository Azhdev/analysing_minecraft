package azhdev.anmc.misc;

import azhdev.anmc.items.anmcItems;
import azhdev.anmc.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


/**
 * 
 * @author Azhdev
 *
 * copyright 2014© Azhdev
 *
 */

public class CreativeTabAM extends CreativeTabs {

    public CreativeTabAM(int par1, String par2Str) {
        
        super(par1, par2Str);
        
    }
    
	public static CreativeTabs tabsAM;
    
	public static void initTab(){
		tabsAM = new CreativeTabAM(12, Reference.MOD_NAME);
	}

@Override
public Item getTabIconItem() {
	return anmcItems.ingot;
}
   
}    