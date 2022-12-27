package com.ceaselesscabbage.elytracraft;

import org.jetbrains.annotations.NotNull;

import com.ceaselesscabbage.elytracraft.items.CabbageElytra;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CabbageElytraLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends ElytraLayer<T, M>{

	private ResourceLocation texture = new ResourceLocation("elytracraft:textures/entity/elytra_flying.png");
	private String identity = "elytra";
	
	public CabbageElytraLayer(RenderLayerParent<T, M> entityRenderer, EntityModelSet modelSet, String texture, String identity) {
		super(entityRenderer, modelSet);
		this.texture = new ResourceLocation(texture);
		this.identity = identity;
	}
	
	// all CabbageElytras and thier respective CabbageElytraLayers have matching identities to tell which one to display
	// TODO: find a less obtuse way of of handling this
	@Override
    public boolean shouldRender(@NotNull ItemStack stack, @NotNull T entity) {
		Item item = stack.getItem();
        return item instanceof CabbageElytra && ((CabbageElytra) item).getIdentity() == this.identity;
    }

    @NotNull
    @Override
    public ResourceLocation getElytraTexture(@NotNull ItemStack stack, @NotNull T entity) {
        return texture;
    }
	
}
