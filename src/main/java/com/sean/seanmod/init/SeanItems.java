package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import com.sean.seanmod.tabs.SeanCreativeModeTabs;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeanMod.modid);

    public static final RegistryObject<Item> SEAN = ITEMS.register("sean",
            ()-> new Item(new Item.Properties().tab(SeanCreativeModeTabs.TAB1))
    );

    public static final RegistryObject<Item> TEST_BUCKET = ITEMS.register("test_bucket",
            ()-> new BucketItem(SeanFluids.TEST_FLUID,
            new Item.Properties().tab(SeanCreativeModeTabs.TAB1).stacksTo(6))
    );
    public static final RegistryObject<Item> MDN_BUCKET = ITEMS.register("mdn_bucket",
            ()-> new BucketItem(SeanFluids.MDN_FLUID,
            new Item.Properties().tab(SeanCreativeModeTabs.TAB1).stacksTo(6))
    );

    public static final RegistryObject<Item>DESTROYER_AXE = ITEMS.register("destroyer_axe",
            ()-> new AxeItem(Tiers.NETHERITE,4,4,new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));

           /** public static final RegistryObject<ChestBlockEntity> CHEST_MIMIC_ITEM = ITEMS.register("chest_mimic_item",
                   ()-> new ChestBlockEntity({...},{...})
        )**/
    //public static final RegistryObject<Item> DEATHBOW = ITEMS.register("deathbow", ()-> new BowItem( )
    //);


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
