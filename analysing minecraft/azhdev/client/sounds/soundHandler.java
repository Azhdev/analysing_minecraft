package client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class soundHandler {
	
	public soundHandler(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	@ForgeSubscribe
	public void onSoundsLoad(SoundLoadEvent event){
		
	}
	private void addSound(SoundLoadEvent event, String name){
		event.manager.soundPoolSounds.addSound("anmc:" + name + ".ogg");
	}
}
