package com.Noah4320.NoahCraft.core.init;


import com.Noah4320.NoahCraft.NoahCraft;
import com.Noah4320.NoahCraft.common.enchantments.EnchantmentTNTRunner;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = NoahCraft.MOD_ID)
public class EnchantmentInit {

	public static final DeferredRegister<Enchantment> ENCHANHTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, NoahCraft.MOD_ID);
	
	public static final RegistryObject<Enchantment> TNT_RUNNER = ENCHANHTMENTS.register("tnt_runner", () -> new EnchantmentTNTRunner(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] {EquipmentSlotType.FEET}));	
	
}
