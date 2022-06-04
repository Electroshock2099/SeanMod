package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanFluids {

    public static final ResourceLocation TEST_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation TEST_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation TEST_OVERLAY_RL = new ResourceLocation("block/water_overlay");
    public static final ResourceLocation MDN_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation MDN_FLOWING_RL = new ResourceLocation("block/lava_flow");
    public static final ResourceLocation MDN_OVERLAY_RL = new ResourceLocation("block/portal_overlay");
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SeanMod.modid);
    public static final DeferredRegister<Block> BLOCKS = SeanBlocks.BLOCKS;

    public static final RegistryObject<FlowingFluid> TEST_FLUID = FLUIDS.register("test_fluid",
            ()-> new ForgeFlowingFluid.Source(SeanFluids.TEST_PROPERTIES));
    public static final RegistryObject<FlowingFluid> TEST_FLOWING = FLUIDS.register("test_flowing",
            ()-> new ForgeFlowingFluid.Flowing(SeanFluids.TEST_PROPERTIES));
    public static final ForgeFlowingFluid.Properties TEST_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> TEST_FLUID.get(), () -> TEST_FLOWING.get(), FluidAttributes.builder(TEST_STILL_RL, TEST_FLOWING_RL)
            //.density(13).viscosity(6).luminosity(9)
            .density(13).viscosity(3).luminosity(6)
            .sound(SoundEvents.SLIME_JUMP)
            .overlay(TEST_OVERLAY_RL)
            //.color(0xbffcba03)
            //ChatFormatting.BLACK
            .color(0xbf312468)
            .temperature(3)
            //.gaseous()
            //.build(TEST_FLUID.get().getSource().
    )
            .slopeFindDistance(3)
            .levelDecreasePerBlock(2)
            .block(
                    () ->SeanFluids.TEST_BLOCK.get()
            )
            .bucket(
                    ()->SeanItems.TEST_BUCKET.get()
            );


    public static final RegistryObject<LiquidBlock> TEST_BLOCK = SeanBlocks.BLOCKS.register("test_block",
            ()-> new LiquidBlock(()-> SeanFluids.TEST_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission()
                    .explosionResistance(100F)
                    .noDrops()

            )
    );

    public static final RegistryObject<FlowingFluid> MDN_FLUID = FLUIDS.register("mdn_fluid",
            ()-> new ForgeFlowingFluid.Source(SeanFluids.TEST_PROPERTIES));
    public static final RegistryObject<FlowingFluid> MDN_FLOWING = FLUIDS.register("mdn_flowing",
            ()-> new ForgeFlowingFluid.Flowing(SeanFluids.TEST_PROPERTIES));
    public static final ForgeFlowingFluid.Properties MDN_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MDN_FLUID.get(), () -> MDN_FLOWING.get(), FluidAttributes.builder(MDN_STILL_RL, MDN_FLOWING_RL)
            //.density(13).viscosity(6).luminosity(9)
            .density(13).viscosity(3).luminosity(6)
            .sound(SoundEvents.GENERIC_BURN)
            .overlay(MDN_OVERLAY_RL)
            .color(0xbffcba03)

            //ChatFormatting.BLACK
            //.color(0xbf312468)
            //.temperature(3)
            //.gaseous()
            //.build(TEST_FLUID.get().getSource().
    )
            .slopeFindDistance(3)
            .levelDecreasePerBlock(2)
            .block(
                    () ->SeanFluids.MDN_BLOCK.get()
            )
            .bucket(
                    ()->SeanItems.MDN_BUCKET.get()
            );


    public static final RegistryObject<LiquidBlock> MDN_BLOCK = BLOCKS.register("mdn_block",
            ()-> new LiquidBlock(
                    ()-> SeanFluids.MDN_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)

                    .noCollission()
                    .explosionResistance(100F)
                    .noDrops()

            )
    );


    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }

}
