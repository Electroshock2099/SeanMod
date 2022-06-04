package com.sean.seanmod.tabs;

import com.sean.seanmod.init.SeanBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SeanCreativeModeTabs {
    public static CreativeModeTab TAB1 = new CreativeModeTab("tab1") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SeanBlocks.SEAN.get());
        }
    };
}
