package com.ceaselesscabbage.elytracraft.items;

import java.util.Random;

import com.ceaselesscabbage.elytracraft.entities.CabbageBoosterEntity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CabbageBooster extends Item {
	
	private Item repairItem;
	double impulse;
	Random random;

	public CabbageBooster(Properties properties, Item repairItem, double impulse) {
		super(properties);
		this.repairItem = repairItem; // item is supplied when constructing this class
		this.impulse = impulse;
		this.random = new Random();
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);
		if (chestItem.canElytraFly(player)) {
		
			// attach a booster entity to the player to handle the actual boosting
			CabbageBoosterEntity boosterEntity = new CabbageBoosterEntity(EntityType.MARKER, level, player, 5, impulse);
			level.addFreshEntity(boosterEntity);
			
			// auto take off by moving the player slightly upwards and giving them a slight upward velocity before initiating flight
			if (!player.isFallFlying()) {
				if (player.isOnGround()) {
					player.moveRelative(.1f, new Vec3(0, 1, 0));
					player.setDeltaMovement(player.getDeltaMovement().add(0, .2, 0));
				}
	            player.startFallFlying();
			}
			
			// booster flame particles
			if (level.isClientSide()) {
				Vec3 looking = player.getLookAngle();
				for (int i = 0; i < 5; i++) {
					level.addParticle(ParticleTypes.FLAME,
							player.getX() + this.random.nextGaussian() * 0.05D, player.getY() + this.random.nextGaussian() * 0.05D, player.getZ() + this.random.nextGaussian() * 0.05D,
							-1*looking.x + this.random.nextGaussian() * 0.05D, -1*looking.y + this.random.nextGaussian() * 0.05D, -1*looking.z + this.random.nextGaussian() * 0.05D);
				}
			}
			
			// damage booster on successful use
			if (!level.isClientSide()) {
				player.getItemInHand(hand).hurtAndBreak(1, player, T -> {
		            T.broadcastBreakEvent(hand);
		         });
			}
		}
		
		return super.use(level, player, hand);
	}
	
	
	@Override
	public boolean isDamageable(ItemStack stack) {
		return true;
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack booster, ItemStack item) {
		return item.getItem() == ((CabbageBooster) booster.getItem()).getRepairItem();
	}
	
	public Item getRepairItem() {
		return this.repairItem;
	}
	
}
