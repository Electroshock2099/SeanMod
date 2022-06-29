package net.sean.seanmod.blocks.liquids;

import net.sean.seanmod.init.SeanFluids;
import net.sean.seanmod.init.SeanItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import java.util.Random;
import java.util.function.Supplier;

import static net.sean.seanmod.init.SeanFluids.*;

public class Test_Fluid_Block extends LiquidBlock {

public void Test_Fluid_Block(Properties properties){
  //super(properties);
    Properties.of(Material.WATER)
            .noCollission()
            .explosionResistance(100F)
            .noDrops()

    ;
};
    public Test_Fluid_Block(Supplier<? extends ForgeFlowingFluid> p_54694_, Properties p_54695_) {
        super(SeanFluids.TEST_SOURCE.get(),
                Properties.of(Material.WATER)
                        .noCollission()
                        .explosionResistance(100F)
                        .noDrops()
        );

    }
    public static final ForgeFlowingFluid.Properties TEST_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> TEST_SOURCE.get(), () -> TEST_FLOWING.get(), FluidAttributes.builder(TEST_STILL_RL, TEST_FLOWING_RL)
            //.density(13).viscosity(6).luminosity(9)
            .density(1300)
            .viscosity(3000)
            .luminosity(6)
            .sound(SoundEvents.SLIME_JUMP,SoundEvents.ANVIL_LAND)
            .overlay(TEST_OVERLAY_RL)
            //.color(0xbffcba03)
            //ChatFormatting.BLACK
            .color(0xe5004400)
            //.color(0xbf312468)
            .temperature(3)

            //.gaseous()
            //.build(TEST_FLUID.get().getSource().
    )
            .canMultiply()
            .slopeFindDistance(12)
            .levelDecreasePerBlock(1)
            .block(
                    () ->SeanFluids.TEST_BLOCK.get()
            )
            .bucket(
                    ()-> SeanItems.TEST_BUCKET.get()
            );


    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        double posX = pos.getX();
        double posY = pos.getY();
        double posZ = pos.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
        //double XV = level

        //level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE
               // ,posX,posY,posZ,2,-7,20);

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
