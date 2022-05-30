package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeanMod.modid);

    public static final RegistryObject<Item> SEAN = ITEMS.register("sean",
            ()-> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC))
    );

    public static final RegistryObject<Item> TEST_BUCKET = ITEMS.register("test_bucket",
            ()-> new BucketItem(SeanFluids.TEST,
            new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(4))
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
