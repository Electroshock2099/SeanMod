package net.sean.seanmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.sean.seanmod.SeanMod;
import net.sean.seanmod.entities.custom.Mo_Entity;
import net.sean.seanmod.init.SeanEntities;
import net.sean.seanmod.init.SeanParticles;
import net.sean.seanmod.particles.GhostlyFlames;
import net.sean.seanmod.particles.Void_ChaosVFX;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeanMod.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SeanEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(SeanParticles.VOID_CHAOS.get(), Void_ChaosVFX.Provider::new);
        Minecraft.getInstance().particleEngine.register(SeanParticles.GHOSTLYFLAMES.get(), GhostlyFlames.Provider::new);
    }

    @SubscribeEvent
    public static void entityAtrributeEvent(EntityAttributeCreationEvent event){
        event.put(SeanEntities.MO.get(),Mo_Entity.setAttributes());
    }
}
