package handlers;

import item.itemInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
//import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class eventHandlerThingy {

	
	//no fall damage boots
	@ForgeSubscribe
	public void onLivingFallEvent(LivingFallEvent fall){
		if(fall.entity != null && fall.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)fall.entity;
			ItemStack armorFeet = player.getCurrentItemOrArmor(1);
			if(armorFeet != null && armorFeet.itemID == itemInfo.feetCremomium_ID){
				fall.setCanceled(true);
			}
		}
	}
	/**
	//jump trousers
	@ForgeSubscribe
	public void onLivingJumpEvent(LivingJumpEvent jump){
		if(jump.entity != null && jump.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)jump.entity;
			ItemStack armorLegs = player.getCurrentItemOrArmor(2);
			if(armorLegs != null && armorLegs.itemID == itemInfo.trousersCremomium_ID){
				player.isAirBorne = true;
				player.motionY = 256;
				player.velocityChanged = true;
			}
		}
	}
	*/
}
