package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SeanBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SeanMod.modid);

    /**public static final RegistryObject<BlockEntityType<Sean_Chest1Entity>> SEAN_CHEST1 = BLOCK_ENTITIES.register("sean_chest1",
            ()-> BlockEntityType.Builder.of(Sean_Chest1Entity::new, SeanBlocks.SEAN_CHEST1.get()).build(null));**/


    private static <T extends BlockEntityType> RegistryObject<T> registerBlockEntity(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCK_ENTITIES.register(name, block);
        return toReturn;
    }


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
