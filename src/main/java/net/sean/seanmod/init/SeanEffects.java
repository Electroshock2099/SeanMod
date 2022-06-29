package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.sean.seanmod.effects.GhostFlameFX;

import net.sean.seanmod.effects.C;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanEffects {

    public static final DeferredRegister<MobEffect> FX = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SeanMod.modid);

    public static final RegistryObject<MobEffect> GHOSTFLAME = FX.register("ghostflame",
            () -> new GhostFlameFX(MobEffectCategory.BENEFICIAL,0xF312468));

    //public static final RegistryObject<MobEffect> GHOSTFLAME = FX.register("ghostflame",
         //   () -> new GhostFlameFX(MobEffectCategory.NEUTRAL,0xF312468));

    public static final RegistryObject<MobEffect> SPECTRE = FX.register("spectre",
            ()-> new C(MobEffectCategory.BENEFICIAL, 0x3124683 ));
            //.addAttributeModifier(Attributes.)

    public static void register(IEventBus eventBus) {
        FX.register(eventBus);
    }
}
