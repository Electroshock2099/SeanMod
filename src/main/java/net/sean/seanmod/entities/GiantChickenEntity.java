package net.sean.seanmod.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.Nullable;

public class GiantChickenEntity extends Entity implements FlyingAnimal {

    public GiantChickenEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Override
    public EntityType<?> getType() {
        return super.getType();
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected SoundEvent getSwimSound() {
        return super.getSwimSound();
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return null;
    }

    @Override
    public boolean isFlying() {
        return false;
    }

    @Override
    public boolean shouldRiderSit() {
        return super.shouldRiderSit();
    }

    @Override
    public boolean canRiderInteract() {
        return super.canRiderInteract();
    }

    @Override
    public boolean canBeRiddenInWater(Entity rider) {
        return super.canBeRiddenInWater(rider);
    }

    @Override
    public MobCategory getClassification(boolean forSpawnCount) {
        return super.getClassification(forSpawnCount);
    }

    @Override
    public boolean isMultipartEntity() {
        return super.isMultipartEntity();
    }

    @Nullable
    @Override
    public PartEntity<?>[] getParts() {
        return super.getParts();
    }

    @Override
    public float getStepHeight() {
        return super.getStepHeight();
    }
}
