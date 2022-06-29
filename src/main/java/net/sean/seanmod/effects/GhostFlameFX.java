package net.sean.seanmod.effects;

import net.minecraft.client.particle.SmokeParticle;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class GhostFlameFX extends MobEffect{
    public GhostFlameFX(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory,color);


    };

    @Override
    public void applyEffectTick(LivingEntity plivingEntity, int pAmplifier) {
        if (!plivingEntity.level.isClientSide()) {

            Double x = plivingEntity.getX();
            Double y = plivingEntity.getY();
            Double z = plivingEntity.getZ();

            plivingEntity.animateHurt();
            plivingEntity.teleportTo(x,y,z);
            plivingEntity.setSpeed(0.2F);
            plivingEntity.isInvertedHealAndHarm();
            plivingEntity.isOnFire();


        }super.applyEffectTick(plivingEntity, pAmplifier);

        //plivingEntity.level.addParticle(SmokeParticle,2,2,2,2,2,2);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return false;
    }
}
