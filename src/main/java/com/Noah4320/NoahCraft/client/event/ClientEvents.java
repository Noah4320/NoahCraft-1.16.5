package com.Noah4320.NoahCraft.client.event;


import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
	
	public static String versionText = "Minecraft Beta 1.5_01";
	public static boolean isPartying = false;


	@SubscribeEvent
	public static void partyTime(PlayerInteractEvent.RightClickBlock event) {
		
		BlockState blockState = event.getWorld().getBlockState(event.getPos());
		Block block = blockState.getBlock();
		
		if (event.getItemStack().getItem() == Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {
			isPartying = true;
			Minecraft mc = Minecraft.getInstance();
			List<CreatureEntity> creatures = event.getPlayer().world.getEntitiesWithinAABB(CreatureEntity.class, new AxisAlignedBB(mc.player.getPositionVec().add(-100, -100, -100), mc.player.getPositionVec().add(100, 100, 100)));
			
			for (CreatureEntity creature : creatures) {
				creature.setCustomName(new StringTextComponent("WORKS"));
				creature.getJumpController().setJumping();
			}
		} else if (event.getItemStack().getItem() != Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {
			isPartying = false;
		}
	}
	
	
	@SubscribeEvent
	public static void whenJumpFinished(LivingFallEvent event) {
		if (event.getEntity() instanceof CreatureEntity) {
			CreatureEntity creature = (CreatureEntity) event.getEntity();
			if (isPartying) {	
				creature.getJumpController().setJumping();
			} else {
				creature.getJumpController().tick();
			}
			
		}
	}
	
	@SubscribeEvent
	public static void renderText(RenderGameOverlayEvent.Post event) {
		Minecraft mc = Minecraft.getInstance();
		FontRenderer renderer = mc.fontRenderer;
		renderer.drawStringWithShadow(event.getMatrixStack(), versionText, 2, 2, 0xFFFFFF);

	}
	
}
