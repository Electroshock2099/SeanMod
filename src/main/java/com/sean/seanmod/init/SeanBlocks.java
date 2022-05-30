package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SeanBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SeanMod.modid);

    public static final RegistryObject<Block> SEAN = BLOCKS.register("sean_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SNOW, MaterialColor.COLOR_BLACK).strength(9f)

            )

    );


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return SeanItems.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }




    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
