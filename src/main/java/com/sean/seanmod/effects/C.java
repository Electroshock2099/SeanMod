package com.sean.seanmod.effects;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

    public class C extends MobEffect{
        public C(MobEffectCategory mobEffectCategory, int color){
            super(mobEffectCategory,color);

        };

        @Override
        public void applyEffectTick(LivingEntity plivingEntity, int pAmplifier) {
            double x = plivingEntity.getX();
            double y = plivingEntity.getY();
            double z = plivingEntity.getZ();
            if (!plivingEntity.level.isClientSide()) {
                plivingEntity.swing(InteractionHand.MAIN_HAND);
                plivingEntity.swing(InteractionHand.OFF_HAND);
                

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
