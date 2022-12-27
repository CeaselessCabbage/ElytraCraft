package com.ceaselesscabbage.elytracraft.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class CabbageElytra extends ElytraItem{
	
	private ResourceLocation texture = new ResourceLocation("elytracraft:textures/entity/elytra_flying.png");
	private String identity = "elytra";
	private double dragMultiplier;
	private Item repairItem;

	public CabbageElytra(Properties properties, String texture, String identity, Item repairItem, double dragMultiplier) {
		super(properties);
		this.texture = new ResourceLocation(texture);
		this.identity = identity; // used to tell which elytra layer to display
		this.repairItem = repairItem;
		this.dragMultiplier = dragMultiplier;
	}
	
	
	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
		return armorType == EquipmentSlot.CHEST;
	}
	
	@Override
	public EquipmentSlot getEquipmentSlot(ItemStack stack) {
		return EquipmentSlot.CHEST;
	}
	
	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		
		// speed up or slow down flight depending on the elytra's drag level
		// this interacts poorly with vanilla physics since it is applied before the vanilla calculations
		//Vec3 orientation = entity.getLookAngle();
		Vec3 motion = entity.getDeltaMovement();
		Vec3 newMotion = new Vec3(motion.x*dragMultiplier, motion.y, motion.z*dragMultiplier);
		entity.setDeltaMovement(newMotion);
		
		// vanilla elytras don't make breaking noises, so I added one
		if (!entity.level.isClientSide() && flightTicks % 20 == 19 && stack.getMaxDamage()-2 == stack.getDamageValue()) {
			entity.broadcastBreakEvent(EquipmentSlot.CHEST);
		}
		
		return super.elytraFlightTick(stack, entity, flightTicks);
	}
	
	// note that this is the texture displayed for the item, not the elytra on the player's back
	public ResourceLocation getFlyingTexture() {
		return texture;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack elytra, ItemStack item) {
		return item.getItem() == ((CabbageElytra) elytra.getItem()).getRepairItem();
	}
	
	private Item getRepairItem() {
		return this.repairItem;
	}
	
	public String getIdentity() {
		return identity;
	}
	
}
