package net.sean.seanmod.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.sean.seanmod.SeanMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sean.seanmod.entities.ChakramEntity;
import net.sean.seanmod.entities.GiantChickenEntity;
import net.sean.seanmod.entities.custom.Mo_Entity;

public class SeanEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, SeanMod.modid);

      public static final RegistryObject<EntityType<GiantChickenEntity>> GC = ENTITIES.register("giant_chicken",
            ()-> EntityType.Builder.of(GiantChickenEntity::new, MobCategory.CREATURE)
                    .sized(5.0F,5.0F)
                    .build(new ResourceLocation(SeanMod.modid,"giant_chicken").toString() )    );

    public static final RegistryObject<EntityType<Mo_Entity>> MO =  ENTITIES.register("mo",
          ()->  EntityType.Builder.of(Mo_Entity::new, MobCategory.CREATURE)
                  .sized(0.9F, 0.8F)
            .build(new ResourceLocation(SeanMod.modid,"mo").toString() )    );

            //public static final EntityType<ChakramEntity> CHAKRAM_ENTITY =  EntityType.Builder.of(ChakramEntity::new, MobCategory.MISC).sized(5.0F,5.0F));
            //public static final EntityType<ChakramEntity> CHAKRAM_ENTITY =  new EntityType.Builder.of(ChakramEntity::new, MobCategory.create()).sized(5.0F,5.0F));


  //public static final EntityType<AreaEffectCloud> AREA_EFFECT_CLOUD = ENTITIES.register("area_effect_cloud", EntityType.Builder.<AreaEffectCloud>of(AreaEffectCloud::new, MobCategory.MISC).fireImmune().sized(6.0F, 0.5F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE));

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            //event.registerEntityRenderer((EntityType)SeanEntities.CHAKRAM_ENTITY, ThrownItemRenderer::new);

        }
        public static void register(IEventBus bus){
            ENTITIES.register(bus);
        }
}
