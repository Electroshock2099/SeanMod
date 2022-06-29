package net.sean.seanmod.init;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.sean.seanmod.SeanMod;
import net.sean.seanmod.blocks.liquids.MDN_Block;
import net.sean.seanmod.blocks.liquids.MDN_Fluid;
import net.sean.seanmod.blocks.liquids.Test_Fluid_Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
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
    public static final ResourceLocation MDN_OVERLAY_RL = new ResourceLocation("block/water_overlay");
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, SeanMod.modid);
    public static final DeferredRegister<Block> BLOCKS = SeanBlocks.BLOCKS;

    public static final RegistryObject<ForgeFlowingFluid> TEST_SOURCE = FLUIDS.register("test_fluid",
            ()-> new ForgeFlowingFluid.Source(Test_Fluid_Block.TEST_PROPERTIES));
    public static final RegistryObject<ForgeFlowingFluid> TEST_FLOWING = FLUIDS.register("test_flowing",
            ()-> new ForgeFlowingFluid.Flowing(Test_Fluid_Block.TEST_PROPERTIES));


    public static final RegistryObject<LiquidBlock> TEST_BLOCK = SeanBlocks.BLOCKS.register("test_block",
            ()-> new LiquidBlock(()-> SeanFluids.TEST_SOURCE.get(), BlockBehaviour.Properties.of(Material.WATER)
            )
    );

    public static final RegistryObject<ForgeFlowingFluid> MDN_SOURCE = FLUIDS.register("mdn_fluid",
            ()-> new MDN_Fluid.Source(MDN_Block.MDN_PROPERTIES));
    public static final RegistryObject<ForgeFlowingFluid> MDN_FLOWING = FLUIDS.register("mdn_flowing",
            ()-> new MDN_Fluid.Flowing(MDN_Block.MDN_PROPERTIES ));

    public static final RegistryObject<LiquidBlock> MDN_BLOCK = BLOCKS.register("mdn_block",
            ()-> new MDN_Block(
                    ()-> SeanFluids.MDN_SOURCE.get(), BlockBehaviour.Properties.of(Material.WATER)
            )
    );


    public static void register(IEventBus eventBus){


        FLUIDS.register(eventBus);
    }

}
