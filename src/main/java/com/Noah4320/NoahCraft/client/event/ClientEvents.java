package com.Noah4320.NoahCraft.client.event;

import com.Noah4320.NoahCraft.client.render.screen.TextGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {

	@SubscribeEvent
	public static void pickUpItem(EntityItemPickupEvent event) {
		System.out.println("Picked up " + event.getItem().getDisplayName());
	}
	
	@SubscribeEvent
	public static void guiTest(PlayerInteractEvent.RightClickItem event) {
		System.out.println("Right clicked " + event.getHand().name());
		
		Minecraft mc = Minecraft.getInstance();
		mc.displayGuiScreen(new TextGui());
	}
	
	@SubscribeEvent
	public static void getShot(ArrowNockEvent event) {
		System.out.println("Nocked!!!");
		Minecraft mc = Minecraft.getInstance();
		mc.player.sendChatMessage("You better watch out!");
	
	}
	
	@SubscribeEvent
	public static void renderText(RenderGameOverlayEvent.Post event) {
		   FontRenderer renderer = Minecraft.getInstance().fontRenderer;
		   renderer.drawStringWithShadow(event.getMatrixStack(), "test", 0, 0, TextFormatting.WHITE.getColor());

	}
	
}
