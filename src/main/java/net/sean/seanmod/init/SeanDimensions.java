package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class SeanDimensions {
    public static ResourceKey<Level> SDIM_KEY  = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(SeanMod.modid, "sdim"));

    public static ResourceKey<DimensionType> SDIM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,SDIM_KEY.getRegistryName());
public void register(){
    System.out.println("Registering Sean\'s Dimensions");
}
}
