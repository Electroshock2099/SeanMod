package net.sean.seanmod.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sean.seanmod.SeanMod;
import net.sean.seanmod.entities.custom.Mo_Entity;
import net.sean.seanmod.entities.models.Mo_Model;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class Mo_Renderer extends GeoEntityRenderer<Mo_Entity> {

    public Mo_Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new Mo_Model());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(Mo_Entity object) {
        return new ResourceLocation(SeanMod.modid, "textures/entity/mo/mo.geo.json");
    }

    @Override
    public RenderType getRenderType(Mo_Entity animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(0.4F,0.4F,0.4F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);

    }
}
