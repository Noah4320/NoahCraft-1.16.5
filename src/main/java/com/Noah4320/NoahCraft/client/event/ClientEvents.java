package com.Noah4320.NoahCraft.client.event;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.Items;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
	
	public static String versionText = "Minecraft Beta 1.5_01";

	@SubscribeEvent
	public static void pickUpItem(EntityItemPickupEvent event) {
		System.out.println("Picked up " + event.getItem().getDisplayName());
	}
	
	@SubscribeEvent
	public static void guiTest(PlayerInteractEvent.RightClickItem event) {
		System.out.println("Right clicked " + event.getHand().name());
	}
	
	@SubscribeEvent
	public static void getShot(ArrowNockEvent event) {
		System.out.println("Nocked!!!");
		Minecraft mc = Minecraft.getInstance();
		mc.player.sendChatMessage("You better watch out!");
	
	}
	
	@SubscribeEvent
	public static void dropDiamonds(LivingDeathEvent event) {
		if (event.getEntity() instanceof PigEntity) {
			
			Random random = new Random();
			
			event.getEntity().entityDropItem(Items.DIAMOND, random.nextInt(3));
			
		}
	}
	
	@SubscribeEvent
	public static void mobChanges(EntityJoinWorldEvent event) {
		
		if (event.getEntity() instanceof CowEntity) {
			CowEntity cow = (CowEntity) event.getEntity();
			cow.setJumping(true);			
			//cow.moveVertical = 200f;
		}
		
	}
	
	@SubscribeEvent
	public static void renderText(RenderGameOverlayEvent.Post event) {
		Minecraft mc = Minecraft.getInstance();
		FontRenderer renderer = mc.fontRenderer;
		renderer.drawStringWithShadow(event.getMatrixStack(), versionText, 2, 2, 0xFFFFFF);

	}
	
}
