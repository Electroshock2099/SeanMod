package com.sean.seanmod.effects;

import net.minecraft.client.particle.SmokeParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class Spectre extends MobEffect{
    public Spectre(MobEffectCategory mobEffectCategory, int color){
        super(mobEffectCategory,color);

    };

    @Override
    public void applyEffectTick(LivingEntity plivingEntity, int pAmplifier) {
        double x = plivingEntity.getX();
        double y = plivingEntity.getY();
        double z = plivingEntity.getZ();
        if (!plivingEntity.level.isClientSide()) {

            if (plivingEntity.level.isNight()){
                //plivingEntity.addEffect(MobEffects.GLOWING.,plivingEntity);

                //plivingEntity.


            //plivingEntity.
                    //AttributeModifier.Operation.ULTIPLY_TOTAL
            //plivingEntity.animateHurt();
            //plivingEntity.teleportTo(x,y,z);
                //plivingEntity.


        }
        }super.applyEffectTick(plivingEntity, pAmplifier);
    }

    @Override
    public MobEffect addAttributeModifier(Attribute p_19473_, String p_19474_, double p_19475_, AttributeModifier.Operation p_19476_) {
        return super.addAttributeModifier(Attributes.ATTACK_SPEED, "spectre",13.0D, AttributeModifier.Operation.MULTIPLY_BASE);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
