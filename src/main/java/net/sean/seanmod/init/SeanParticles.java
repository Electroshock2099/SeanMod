package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanParticles {


    public static final DeferredRegister<ParticleType<?>> PFX =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SeanMod.modid);

   // public static final RegistryObject<SimpleParticleType> VOID_CHAOS = PFX.register(SeanMod.modid,
     //       ()-> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> VOID_CHAOS = PFX.register("void_chaos",()->new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> GHOSTLYFLAMES = PFX.register("ghostlyflames", () -> new SimpleParticleType(true));
            //0xF312468
            //0x3124687
/**
    public static final RegistryObject<SimpleParticleType>VOID_CHAOS = VFX.register("void_chaos",
            () -> new Void_ChaosVFX(true)
            //0xF312468));
            //0x3124687
    );**/

    //public static final ForgeRegistries<SimpleParticleType>


    public static void register(IEventBus eventBus) {
        PFX.register(eventBus);
    }
}
