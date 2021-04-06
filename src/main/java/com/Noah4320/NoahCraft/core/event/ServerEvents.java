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
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ServerEvents {

	public static Minecraft mc = Minecraft.getInstance();
	private static List<AnimalEntity> creatures;
	private static boolean isPartying = false;


	@SubscribeEvent
	public static void partyTime(PlayerInteractEvent.RightClickBlock event) {
		
		BlockState blockState = event.getWorld().getBlockState(event.getPos());
		Block block = blockState.getBlock();
		
		if (event.getItemStack().getItem() == Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {			
			creatures = event.getPlayer().world.getEntitiesWithinAABB(AnimalEntity.class, new AxisAlignedBB(mc.player.getPositionVec().add(-100, -100, -100), mc.player.getPositionVec().add(100, 100, 100)));
			
			for (AnimalEntity creature : creatures) {
				creature.setCustomName(new StringTextComponent("PARTYING"));
				creature.getJumpController().setJumping();
				creature.getNavigator().setPath(creature.getNavigator().getPathToEntity(mc.player, 0), 1);
			}
			
			isPartying = true;
			
		} else if (event.getItemStack().getItem() != Items.MUSIC_DISC_CAT && block == Blocks.JUKEBOX) {
			
			if (creatures != null) {
				for (AnimalEntity creature : creatures) {
					creature.setCustomName(null);
					creature.getJumpController().tick();
				}
				creatures.clear();
			}
			
			isPartying = false;
		}
	}
	
	@SubscribeEvent
	public static void waitASec(final TickEvent.ServerTickEvent event) {
		  if (creatures != null && isPartying) {
			  for (AnimalEntity creature : creatures) {
					creature.getJumpController().setJumping();
					creature.getNavigator().setPath(creature.getNavigator().getPathToEntity(mc.player, 0), 1);
				}
		  }
	}
	
}
