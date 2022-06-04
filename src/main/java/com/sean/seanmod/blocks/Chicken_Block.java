package com.sean.seanmod.blocks;

import com.sean.seanmod.init.SeanParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class Chicken_Block extends Block {
    public Chicken_Block(Properties p_49795_) {
        super(p_49795_);
    }


    public void animateTick(BlockState p_60462_, ServerLevel level, BlockPos pos, Random p_60465_) {
        super.animateTick(p_60462_, level, pos, p_60465_);
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
       //double XV = level
        level.addParticle(SeanParticles.GHOSTLYFLAMES.get(),posX,posY,posZ,6,6,0.3
        );
    }
}
