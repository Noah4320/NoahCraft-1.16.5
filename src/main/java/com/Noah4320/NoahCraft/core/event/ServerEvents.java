package com.Noah4320.NoahCraft.core.event;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEvents {

	public static boolean isPartying = false;
	public static Minecraft mc = Minecraft.getInstance();


	@SubscribeEvent
	public static void partyTime(PlayerInteractEvent.RightClickBlock event) {
		
		BlockState blockState = event.getWorld().getBlockState(event.getPos());
		Block block = blockState.getBlock();
		
		if (event.getItemStack().getItem() == Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {
			isPartying = true;
			
			List<AnimalEntity> creatures = event.getPlayer().world.getEntitiesWithinAABB(AnimalEntity.class, new AxisAlignedBB(mc.player.getPositionVec().add(-100, -100, -100), mc.player.getPositionVec().add(100, 100, 100)));
			
			for (AnimalEntity creature : creatures) {
				creature.setCustomName(new StringTextComponent("WORKS"));
				creature.getJumpController().setJumping();
				creature.getNavigator().setPath(creature.getNavigator().getPathToEntity(mc.player, 0), 1);
			}
		} else if (event.getItemStack().getItem() != Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {
			isPartying = false;
		}
	}
	
	
	@SubscribeEvent
	public static void whenJumpFinished(LivingFallEvent event) {
		event.getEntity().setCustomName(new StringTextComponent("JUMPING"));
		if (event.getEntity() instanceof AnimalEntity) {
			AnimalEntity creature = (AnimalEntity) event.getEntity();

			if (isPartying) {	
				creature.getJumpController().setJumping();
				creature.getNavigator().setPath(creature.getNavigator().getPathToEntity(mc.player, 0), 1);
				
			} else {
				creature.getJumpController().tick();
			}
			
		}
	}
	
}
