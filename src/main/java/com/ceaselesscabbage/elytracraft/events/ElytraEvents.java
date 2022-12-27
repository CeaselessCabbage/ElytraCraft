package com.ceaselesscabbage.elytracraft.events;

import com.ceaselesscabbage.elytracraft.CabbageElytraLayer;
import com.ceaselesscabbage.elytracraft.ElytraCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ElytraCraft.MOD_ID, value = Dist.CLIENT, bus = Bus.MOD)
public class ElytraEvents {
	

	
	@SubscribeEvent
	public static void addWings(EntityRenderersEvent.AddLayers event) {
		for (String skinName: event.getSkins()) {
			PlayerRenderer renderer = event.getSkin(skinName);
			
			// vanilla material elytras             texture location:                                           identity:
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/wood_elytra_flying.png",       "wood_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/stone_elytra_flying.png",      "stone_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/copper_elytra_flying.png",     "copper_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/iron_elytra_flying.png",       "iron_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/gold_elytra_flying.png",       "gold_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/diamond_elytra_flying.png",    "diamond_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/netherite_elytra_flying.png",  "netherite_elytra"));
			renderer.addLayer(layerMaker(renderer,  "elytracraft:textures/entity/emerald_elytra_flying.png",    "emerald_elytra"));
			
		}
	}
	
	private static CabbageElytraLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> layerMaker(PlayerRenderer renderer, String texture_address, String identity) {
		return new CabbageElytraLayer<>((PlayerRenderer) renderer, Minecraft.getInstance().getEntityModels(),
				texture_address, identity);
	}
	
}
