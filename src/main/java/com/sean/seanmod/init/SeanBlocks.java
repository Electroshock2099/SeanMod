package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
//import com.sean.seanmod.blocks.custom.SPortalBlock;
import com.sean.seanmod.blocks.Chicken_Block;
import com.sean.seanmod.blocks.custom.SPortalBlock;
import com.sean.seanmod.tabs.SeanCreativeModeTabs;
import net.minecraft.core.particles.ParticleType;
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
            SeanCreativeModeTabs.TAB1

    );

    public static final RegistryObject<Block> CHICKEN_BLOCK = registerBlock("chicken_block",
            ()-> new Chicken_Block(BlockBehaviour.Properties.of(Material.BAMBOO)),
            SeanCreativeModeTabs.TAB1 );
//     public static final RegistryObject<Block> SPORTAL_BLOCK = registerNoItem("sean_portal_block", SPortalBlock::new);x cv


    public static final RegistryObject<Block> RAW_CHICKEN_BLOCK = registerBlock("chickenblock_raw",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_PINK).strength(9f)
            ),SeanCreativeModeTabs.TAB1
    );

    public static final RegistryObject<Block> COOKED_CHICKEN_BLOCK = registerBlock("chickenblock_cooked",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_BROWN).strength(9f)
            ),SeanCreativeModeTabs.TAB1
    );

    public static final RegistryObject<Block> RAW_PORKCHOP_BLOCK = registerBlock("porkchopblock_raw",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_PINK).strength(9f)
            ),SeanCreativeModeTabs.TAB1
    );

    public static final RegistryObject<Block> COOKED_PORKCHOP_BLOCK = registerBlock("porkchopblock_cooked",
            ()-> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE, MaterialColor.COLOR_YELLOW).strength(9f)
            ),SeanCreativeModeTabs.TAB1
    );


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
