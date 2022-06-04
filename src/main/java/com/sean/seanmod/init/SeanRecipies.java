package com.sean.seanmod.init;

import com.sean.seanmod.SeanMod;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeanRecipies {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPIES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SeanMod.modid);



    public static void register(IEventBus bus){
        RECIPIES.register(bus);
    }
}
