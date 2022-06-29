package net.sean.seanmod.fluids;

import net.sean.seanmod.init.SeanFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class TestFluid extends ForgeFlowingFluid {

    public  TestFluid(Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getSource() {
        return SeanFluids.TEST_SOURCE.get();
    }

    @Override
    public Fluid getFlowing(){
        return SeanFluids.TEST_FLOWING.get();
    }

    @Override
    protected boolean canConvertToSource() {
        return true;//super.canConvertToSource();
    }

    @Override
    public boolean isEntityInside(FluidState state, LevelReader level, BlockPos pos, Entity entity, double yToTest, HolderSet<Fluid> tag, boolean testingHead) {
        return super.isEntityInside(state, level, pos, entity, yToTest, tag, testingHead);
    }

    protected boolean canSourcesMultiply() {
        return true;
    }


    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 1000;
    }
}
