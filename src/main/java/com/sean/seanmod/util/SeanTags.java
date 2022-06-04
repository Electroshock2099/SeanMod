package com.sean.seanmod.util;

import com.sean.seanmod.SeanMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SeanTags {

    public static class Blocks {
        public static final TagKey<Block> DOWSING_ROD_VALUABLES
                = tag("dowsing_rod_valuables");

        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = tag("sean_portal_blocks" );

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(SeanMod.modid, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CITRINE_GEMS = forgeTag("gems/citrine");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(SeanMod.modid, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
