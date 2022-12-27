package com.ceaselesscabbage.elytracraft.init;

import com.ceaselesscabbage.elytracraft.ElytraCraft;
import com.ceaselesscabbage.elytracraft.items.CabbageBooster;
import com.ceaselesscabbage.elytracraft.items.CabbageElytra;
import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElytraCraft.MOD_ID);

	
	
	
	public static final RegistryObject<Item> WOOD_ELYTRA = register("wood_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(50),
					"elytracraft:textures/entity/wood_elytra_flying.png", "wood_elytra", Items.OAK_WOOD, .98d));
	
	public static final RegistryObject<Item> STONE_ELYTRA = register("stone_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(100),
					"elytracraft:textures/entity/stone_elytra_flying.png", "stone_elytra", Items.COBBLESTONE, .982d));
	
	public static final RegistryObject<Item> COPPER_ELYTRA = register("copper_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(200),
					"elytracraft:textures/entity/copper_elytra_flying.png", "copper_elytra", Items.COPPER_INGOT, .985d));
	
	public static final RegistryObject<Item> IRON_ELYTRA = register("iron_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(400),
					"elytracraft:textures/entity/iron_elytra_flying.png", "iron_elytra", Items.IRON_INGOT, .988d));
	
	public static final RegistryObject<Item> GOLD_ELYTRA = register("gold_elytra",
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(50),
					"elytracraft:textures/entity/gold_elytra_flying.png", "gold_elytra", Items.GOLD_INGOT, 1.001d));
	
	public static final RegistryObject<Item> DIAMOND_ELYTRA = register("diamond_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(1000),
					"elytracraft:textures/entity/diamond_elytra_flying.png", "diamond_elytra", Items.DIAMOND, .995d));
	
	public static final RegistryObject<Item> NETHERITE_ELYTRA = register("netherite_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(1500).fireResistant(),
					"elytracraft:textures/entity/netherite_elytra_flying.png", "netherite_elytra", Items.NETHERITE_INGOT, 1d));
	
	public static final RegistryObject<Item> EMERALD_ELYTRA = register("emerald_elytra", 
			() -> new CabbageElytra(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(400),
					"elytracraft:textures/entity/emerald_elytra_flying.png", "emerald_elytra", Items.EMERALD, .99d));
	

	
	
	
	public static final RegistryObject<Item> WOOD_BOOSTER = register("wood_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(25), Items.OAK_WOOD, .01));
	
	public static final RegistryObject<Item> STONE_BOOSTER = register("stone_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(50), Items.COBBLESTONE, .013));
	
	public static final RegistryObject<Item> COPPER_BOOSTER = register("copper_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(70), Items.COPPER_INGOT, .015));
	
	public static final RegistryObject<Item> IRON_BOOSTER = register("iron_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(100), Items.IRON_INGOT, .017));
	
	public static final RegistryObject<Item> GOLD_BOOSTER = register("gold_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(25), Items.GOLD_INGOT, .03));
	
	public static final RegistryObject<Item> DIAMOND_BOOSTER = register("diamond_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(200), Items.DIAMOND, .02));
	
	public static final RegistryObject<Item> NETHERITE_BOOSTER = register("netherite_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(300).fireResistant(), Items.NETHERITE_INGOT, .022));
	
	public static final RegistryObject<Item> EMERALD_BOOSTER = register("emerald_booster",
			() -> new CabbageBooster(new Item.Properties().tab(ElytraCraft.ELYTRA_TAB).durability(120), Items.EMERALD, .018));
	
	
	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
	
}
