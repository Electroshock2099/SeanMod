package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
//import com.sean.seanmod.blocks.custom.SPortalBlock;
import net.sean.seanmod.blocks.custom.Chicken_Block;
import net.sean.seanmod.blocks.custom.Dark_ShardBlock;
import net.sean.seanmod.blocks.custom.JumpPad;
import net.sean.seanmod.tabs.SeanCreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class SeanBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SeanMod.modid);

    public static final RegistryObject<Block> SEAN = registerBlock("sean_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_BLACK).strength(9f)),
            SeanCreativeModeTabs.TAB1);

    public static final RegistryObject<Block> JUMPPAD = registerBlock("jumppad",
            ()-> new JumpPad(BlockBehaviour.Properties.of(Material.SCULK, MaterialColor.COLOR_BLACK).strength(9f)),
            SeanCreativeModeTabs.TAB1);

    public static final RegistryObject<Block> DARK_SHARD_BLOCK = registerBlock("dark_shard_block",
            ()-> new Dark_ShardBlock(BlockBehaviour.Properties.of(Material.SCULK, MaterialColor.COLOR_BLACK).strength(9f).requiresCorrectToolForDrops()),
            SeanCreativeModeTabs.TAB1,"Block made of §l§0§k!!!§r§0§lDark Shards§k§l!!!");

    public static final RegistryObject<Block> CHICKEN_BLOCK = registerBlock("chicken_block",
            ()-> new Chicken_Block(BlockBehaviour.Properties.of(Material.VEGETABLE).strength(7F,7F)),
            SeanCreativeModeTabs.TAB1,"Mysterious block seemingly made of chicken");
//     public static final RegistryObject<Block> SPORTAL_BLOCK = registerNoItem("sean_portal_block", SPortalBlock::new);x cv

    public static final RegistryObject<Block> RAW_CHICKEN_BLOCK = registerBlock("chicken_block_raw",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_PINK).strength(9f)),
            SeanCreativeModeTabs.TAB1,"Block made of raw chicken");

    public static final RegistryObject<Block> COOKED_CHICKEN_BLOCK = registerBlock("chicken_block_cooked",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_BROWN).strength(9f)),
            SeanCreativeModeTabs.TAB1,"Block made of cooked chicken");

    public static final RegistryObject<Block> RAW_PORKCHOP_BLOCK = registerBlock("porkchop_block_raw",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_PINK).strength(9f)),
            SeanCreativeModeTabs.TAB1,"Block made of raw porkchops");

    public static final RegistryObject<Block> COOKED_PORKCHOP_BLOCK = registerBlock("porkchop_block_cooked",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_YELLOW).strength(9f)),
            SeanCreativeModeTabs.TAB1,"Block made of cooked pork chops");

/**
    public static final RegistryObject<Sean_Chest1Block> SEAN_CHEST1 = registerBlock("sean_chest1",
            ()-> new Sean_Chest1Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).requiresCorrectToolForDrops()),SeanCreativeModeTabs.TAB1);
**/

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab, String tooltipKey) {
        return SeanItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return SeanItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
