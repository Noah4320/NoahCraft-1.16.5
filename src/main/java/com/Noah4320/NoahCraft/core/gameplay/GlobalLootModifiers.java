package com.Noah4320.NoahCraft.core.gameplay;

import java.util.List;


import com.Noah4320.NoahCraft.NoahCraft;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(NoahCraft.MOD_ID)
public class GlobalLootModifiers {
	
	public GlobalLootModifiers() {
		 GLM.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static void init(IEventBus bus) {
		GLM.register(bus);
	}
	

	private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, NoahCraft.MOD_ID);
	
	private static final RegistryObject<SpawnChestLootModifier.Serializer> SPAWN_CHEST_LOOT = GLM.register("modified_spawn_chest", SpawnChestLootModifier.Serializer::new);

private static class SpawnChestLootModifier extends LootModifier {

	protected SpawnChestLootModifier(ILootCondition[] conditionsIn) {
		super(conditionsIn);
	}
	
	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		System.out.println("***************************************");
		return null;
	}
	
	private static class Serializer extends GlobalLootModifierSerializer<SpawnChestLootModifier> {

		@Override
		public SpawnChestLootModifier read(ResourceLocation location, JsonObject object, ILootCondition[] ailootcondition) {
            System.out.println("***************************************");

			return null;
		}

		@Override
		public JsonObject write(SpawnChestLootModifier instance) {
			return null;
		}
		
	}
}
}


