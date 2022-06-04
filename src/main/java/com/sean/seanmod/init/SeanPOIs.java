package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanPOIs {
    public static final DeferredRegister<PoiType> POI =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SeanMod.modid);
    public static final RegistryObject<PoiType> S_PORTAL =
            POI.register("s_portal", () -> new PoiType("s_portal",
                    PoiType.getBlockStates(SeanBlocks.SEAN.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
