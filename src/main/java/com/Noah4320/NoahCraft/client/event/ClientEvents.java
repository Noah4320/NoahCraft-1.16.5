package com.Noah4320.NoahCraft.client.event;


import com.Noah4320.NoahCraft.config.CustomConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
	
	public static String versionText = CustomConfig.read();
	
	@SubscribeEvent
	public static void renderText(RenderGameOverlayEvent.Text event) {
		Minecraft mc = Minecraft.getInstance();
		FontRenderer renderer = mc.fontRenderer;
		renderer.drawStringWithShadow(event.getMatrixStack(), versionText, 2, 2, 0xFFFFFF);

	}
	
}
