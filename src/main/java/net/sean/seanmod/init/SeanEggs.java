package net.sean.seanmod.init;

import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sean.seanmod.SeanMod;
import net.sean.seanmod.tabs.SeanCreativeModeTabs;

public class SeanEggs {
    public static final DeferredRegister<Item> EGGS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeanMod.modid);
    //public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.EGGS, "thrown_weapons");
    public static final RegistryObject<ForgeSpawnEggItem> MO = EGGS.register("mo_spawn_egg",
            ()-> new ForgeSpawnEggItem(SeanEntities.MO, 0x152814, 0x152814,new Item.Properties()
                    .tab(SeanCreativeModeTabs.TAB1)));

    /**public static final RegistryObject<Item> SEAN = EGGS.register("sean",
            ()-> new Item(new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));**/
   
    public static void register(IEventBus eventBus){
        EGGS.register(eventBus);
    }


}
