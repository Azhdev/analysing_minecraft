package anmc.misc;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


/**
 * 
 * creative tab
 * 
 * @author azhdev
 *
 *this is the official analysing minecraft creative tab. 
 *
 */

public class CreativeTabAM extends CreativeTabs {

    public CreativeTabAM(int par1, String par2Str) {
        
        super(par1, par2Str);
        
    }
    
   @Override
   @SideOnly(Side.CLIENT)
    // the item that is being displayed on the gui 
     public int getTabIconItemIndex() {
       return Item.writtenBook.itemID;
        
        
    }
   
}    