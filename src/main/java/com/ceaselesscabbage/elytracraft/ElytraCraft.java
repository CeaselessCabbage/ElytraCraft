package com.ceaselesscabbage.elytracraft;

import com.ceaselesscabbage.elytracraft.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("elytracraft")
public class ElytraCraft {
	
	public static final String MOD_ID = "elytracraft";
	
	public static final CreativeModeTab ELYTRA_TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.DIAMOND_ELYTRA.get());
		}
	};
	
	public ElytraCraft() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
