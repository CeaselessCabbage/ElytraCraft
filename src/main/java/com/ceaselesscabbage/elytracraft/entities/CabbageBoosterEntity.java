package com.ceaselesscabbage.elytracraft.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class CabbageBoosterEntity extends Entity {	   
	
	private LivingEntity player;
	private int lifeRemaining;
	private double impulse;

	public CabbageBoosterEntity(EntityType<?> type, Level level, LivingEntity player, int lifeRemaining, double impulse) {
		super(type, level);
		this.player = player;
		this.lifeRemaining = lifeRemaining;
		this.impulse = impulse;
	}
	
	@Override
	public void tick() {
		if (this.lifeRemaining == 0) {
			this.discard();
		}
		this.lifeRemaining--;
		if (this.player.isFallFlying()) {
			Vec3 orientation = this.player.getLookAngle();
			orientation.multiply(1,  .6,  1);
			Vec3 motion = this.player.getDeltaMovement();
			Vec3 newMotion = motion.add(orientation.scale(this.impulse));
			this.player.setDeltaMovement(newMotion);
			this.player.hurtMarked = true; // needed for impulse to be applied
			
			this.setPos(this.player.getX(), this.player.getY(), this.player.getZ());
	        this.setDeltaMovement(this.player.getDeltaMovement());
			
			this.level.playSound((Player)null, this.getX() + this.getDeltaMovement().x, this.getY() + this.getDeltaMovement().y, this.getZ() + this.getDeltaMovement().z, SoundEvents.BLAZE_BURN, SoundSource.AMBIENT, .3F, 100F);
		}
		
		
		
		super.tick();
		
	}

	@Override
	protected void defineSynchedData() {
		
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		Entity entity = this.player;
	    return new ClientboundAddEntityPacket(this, entity == null ? 0 : entity.getId());
	}

	
	
}
