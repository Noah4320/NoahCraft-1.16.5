package com.Noah4320.NoahCraft.core.init;

import com.Noah4320.NoahCraft.NoahCraft;
import com.Noah4320.NoahCraft.common.items.PartyMusicDisc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NoahCraft.MOD_ID);
	
	public static final RegistryObject<Item> PARTY_MUSIC_DISC = ITEMS.register("party_disc", () -> new PartyMusicDisc(1, SoundInit.PARTY_DISC_LAZY.get(), new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
	
}
