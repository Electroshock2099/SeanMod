package net.sean.seanmod.init;

import net.sean.seanmod.SeanMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SeanRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SeanMod.modid);



    public static void register(IEventBus bus){
        RECIPES.register(bus);
    }
}
