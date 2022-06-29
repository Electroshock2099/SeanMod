package net.sean.seanmod.blocks.liquids;

import net.sean.seanmod.init.SeanFluids;
import net.sean.seanmod.init.SeanItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class MDN_Fluid extends ForgeFlowingFluid {
   /** public static final ForgeFlowingFluid.Properties MDN_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MDN_SOURCE.get(), () -> MDN_FLOWING.get(), FluidAttributes.builder(MDN_STILL_RL, MDN_FLOWING_RL)
            //.density(13).viscosity(6).luminosity(9)
            .density(13000).viscosity(1300).luminosity(60)
            .sound(SoundEvents.GENERIC_BURN)
            .overlay(MDN_OVERLAY_RL)

            //.color(0xbffcba03)

            //ChatFormatting.BLACK
            .color(0xbf312468)
            //.temperature(3)
            //.gaseous()
            //.build(TEST_FLUID.get().getSource().
    )
            .canMultiply()
            //.slopeFindDistance(3)
            .levelDecreasePerBlock(2)
            .block(
                    () -> SeanFluids.MDN_BLOCK.get()
            )
            .bucket(
                    ()-> SeanItems.MDN_BUCKET.get()
            );**/

    protected MDN_Fluid(Properties properties) {
        super(new Properties(
        () -> SeanFluids.MDN_SOURCE.get(), () -> SeanFluids.MDN_FLOWING.get(), FluidAttributes.builder(SeanFluids.MDN_STILL_RL, SeanFluids.MDN_FLOWING_RL)
                //.density(13).viscosity(6).luminosity(9)
                .density(13000)
                .viscosity(1300)
                .luminosity(60)
                .sound(SoundEvents.GENERIC_BURN)
                .overlay(SeanFluids.MDN_OVERLAY_RL)
                //.color(0xbffcba03)
                .color(0xbf312468)
        )
                //.slopeFindDistance(3)
                .block(
                        () -> SeanFluids.MDN_BLOCK.get()
                )
                .bucket(
                        ()-> SeanItems.MDN_BUCKET.get()
                )
        );
    }

    @Override
    protected FluidAttributes createAttributes() {

        FluidAttributes.builder(SeanFluids.MDN_STILL_RL, SeanFluids.MDN_FLOWING_RL);
        return super.createAttributes();
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 2000;
    }
}
