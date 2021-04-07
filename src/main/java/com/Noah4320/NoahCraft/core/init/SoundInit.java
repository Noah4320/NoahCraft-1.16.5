package com.Noah4320.NoahCraft.core.init;

import com.Noah4320.NoahCraft.NoahCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NoahCraft.MOD_ID);
	
	public static final Lazy<SoundEvent> PARTY_DISC_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(NoahCraft.MOD_ID, "item.party_disc")));
	
	public static final RegistryObject<SoundEvent> PARTY_DISC = SOUNDS.register("item.party_disc", PARTY_DISC_LAZY);
	
}
