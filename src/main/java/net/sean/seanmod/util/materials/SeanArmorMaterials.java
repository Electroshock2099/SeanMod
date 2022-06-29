package net.sean.seanmod.util.materials;

import net.sean.seanmod.init.SeanItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class SeanArmorMaterials {
    //public static final Material LIQUID = (new Material.Builder(MaterialColor.WATER)).noCollider().nonSolid().replaceable().liquid().build();
    public static final ForgeTier DARKNESS = new ForgeTier(13, 1300, 12.0F,
            13.0F, 13, BlockTags.NEEDS_DIAMOND_TOOL,
            ()->Ingredient.of(SeanItems.SEAN.get())
            );
    public static final ForgeTier DEATH = new ForgeTier(666, 666, 12.0F,
            66.6F, 666, BlockTags.WITHER_IMMUNE,
            () -> Ingredient.of(SeanItems.DARK_SHARD.get()));


    //public static final Material TEST_LIQ_MAT = new Material.Builder(Map)
    //public static final Material RRW = (new Material.Builder(MaterialColor.WATER)).noCollider().notSolidBlocking().nonSolid().destroyOnPush().replaceable().liquid().build();

}
