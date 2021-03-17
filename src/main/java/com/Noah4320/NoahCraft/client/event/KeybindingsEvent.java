package com.Noah4320.NoahCraft.client.event;

import com.Noah4320.NoahCraft.NoahCraft;
import com.Noah4320.NoahCraft.client.render.screen.TextGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeybindingsEvent {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void onEvent(KeyInputEvent event) {

		KeyBinding guiKeybind = NoahCraft.guiKeybind;
		Minecraft mc = Minecraft.getInstance();
		
		if (event.getKey() == guiKeybind.getKey().getKeyCode() && mc.currentScreen == null ) {		
			mc.displayGuiScreen(new TextGui());
		}
	}
}
