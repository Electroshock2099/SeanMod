package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, SeanMod.modid);

    public static final RegistryObject<FlowingFluid> TEST = FLUIDS.register("test_fluid",
            ()-> new ForgeFlowingFluid.Source(SeanFluids.TEST_P));
    public static final RegistryObject<FlowingFluid> TEST_FLOWING = FLUIDS.register("test_flowing",
            ()-> new ForgeFlowingFluid.Flowing(SeanFluids.TEST_P));
    public static final ForgeFlowingFluid.Properties TEST_P = new ForgeFlowingFluid.Properties(
            () -> TEST.get(), () -> TEST_FLOWING.get(), FluidAttributes.builder(TEST_STILL_RL, TEST_FLOWING_RL)
            .density(13).viscosity(6).luminosity(9)
            .sound(SoundEvents.HONEY_DRINK)
            .overlay(TEST_OVERLAY_RL)
            .color(0xbffcba03)
    )
            .slopeFindDistance(3).levelDecreasePerBlock(1)
            .block(() ->SeanFluids.TEST_BLOCK.get()).bucket(()->SeanItems.TEST_BUCKET.get()
            );





    public static final RegistryObject<LiquidBlock> TEST_BLOCK = SeanBlocks.BLOCKS.register("test_block",
            ()-> new LiquidBlock(()-> SeanFluids.TEST.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100F).noDrops())
    );


    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }

}
