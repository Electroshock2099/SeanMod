package com.sean.seanmod.event;

import com.sean.seanmod.SeanMod;
import com.sean.seanmod.init.SeanParticles;
import com.sean.seanmod.particles.GhostlyFlames;
import com.sean.seanmod.particles.Void_ChaosVFX;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SeanMod.modid, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SeanEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(SeanParticles.GHOSTLYFLAMES.get(),
                Void_ChaosVFX.Provider::new);
    }
}
