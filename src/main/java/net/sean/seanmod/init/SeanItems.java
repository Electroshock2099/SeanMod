package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.sean.seanmod.items.custom.SeanItem;
import net.sean.seanmod.items.custom.DataTabletItem;
import net.sean.seanmod.items.weapons.Chakram;
import net.sean.seanmod.items.weapons.DeathBow;
import net.sean.seanmod.tabs.SeanCreativeModeTabs;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SeanMod.modid);
    //public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, "thrown_weapons");
    public static final RegistryObject<Item> SEAN = ITEMS.register("sean", ()-> new SeanItem(new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));

    /**public static final RegistryObject<Item> SEAN = ITEMS.register("sean",
            ()-> new Item(new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));**/
    public static final RegistryObject<Item> DARK_SHARD = ITEMS.register("dark_shard", ()-> new Item(new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));

    public static final RegistryObject<Item> TEST_BUCKET = ITEMS.register("test_bucket", ()-> new BucketItem(SeanFluids.TEST_SOURCE, new Item.Properties().tab(SeanCreativeModeTabs.TAB1).stacksTo(6))
    );
    public static final RegistryObject<Item> MDN_BUCKET = ITEMS.register("mdn_bucket", ()-> new BucketItem(SeanFluids.MDN_SOURCE, new Item.Properties().tab(SeanCreativeModeTabs.TAB1).stacksTo(6))
    );

    //public static final RegistryObject<Item>
    public static final RegistryObject<Item> CHAKRAM = ITEMS.register("chakram", ()-> new Chakram(Tiers.NETHERITE,7,7,new Item.Properties() )  );

    public static final RegistryObject<Item>DESTROYER_AXE = ITEMS.register("destroyer_axe", ()-> new AxeItem(Tiers.NETHERITE,4,4,new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));
/**
    public static final RegistryObject<BlockItem>SEAN_CHEST = ITEMS.register("sean_chest1",
            ()-> new BlockItem(SeanBlocks.SEAN_CHEST1.get(), new Item.Properties().tab(SeanCreativeModeTabs.TAB1)));**/

           /** public static final RegistryObject<ChestBlockEntity> CHEST_MIMIC_ITEM = ITEMS.register("chest_mimic_item",
                   ()-> new ChestBlockEntity({...},{...})
        )**/
    public static final RegistryObject<Item> DEATHBOW = ITEMS.register("deathbow", ()-> new DeathBow(new BowItem.Properties().tab(SeanCreativeModeTabs.TAB1))
    );

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().tab(SeanCreativeModeTabs.TAB1).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
