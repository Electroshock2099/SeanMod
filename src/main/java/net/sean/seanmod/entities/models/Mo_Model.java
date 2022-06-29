package net.sean.seanmod.entities.models;

import net.minecraft.resources.ResourceLocation;
import net.sean.seanmod.SeanMod;
import net.sean.seanmod.entities.custom.Mo_Entity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Mo_Model extends AnimatedGeoModel<Mo_Entity> {
    @Override
    public ResourceLocation getModelLocation(Mo_Entity object) {
        return new ResourceLocation(SeanMod.modid, "geo/mo.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Mo_Entity object) {
        return new ResourceLocation(SeanMod.modid, "textures/entity/mo/mo.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Mo_Entity animatable) {
        return new ResourceLocation(SeanMod.modid, "animations/mo.animation.json");
    }
}
