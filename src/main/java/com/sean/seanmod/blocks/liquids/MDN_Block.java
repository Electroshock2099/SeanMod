package com.sean.seanmod.blocks.liquids;

import com.sean.seanmod.init.SeanFluids;
import com.sean.seanmod.init.SeanParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Material;

import java.util.Random;
import java.util.function.Supplier;

public class MDN_Block extends LiquidBlock {

    public MDN_Block(Supplier<? extends FlowingFluid> p_54694_, Properties p_54695_) {
        super(SeanFluids.MDN_FLUID.get(),
                BlockBehaviour.Properties.of(Material.WATER)
                        .noCollission()
                        .explosionResistance(100F)
                        .noDrops()

        );

    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
        //double XV = level
        level.addParticle(SeanParticles.GHOSTLYFLAMES.get(),posX,posY,posZ,6,6,0.3);
        level.addParticle(ParticleTypes.ASH
                ,posX,posY,posZ,0,0,1);

        super.randomTick(state, level, pos, random);
    }

/**
    public void animateTick(BlockState p_60462_, ServerLevel level, BlockPos pos, Random p_60465_) {
        super.animateTick(p_60462_, level, pos, p_60465_);
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
       //double XV = level
        level.addParticle(SeanParticles.GHOSTLYFLAMES.get(),posX,posY,posZ,6,6,0.3);
        level.addParticle(ParticleTypes.ASH
                ,posX,posY,posZ,0,0,1);
    }**/

}
