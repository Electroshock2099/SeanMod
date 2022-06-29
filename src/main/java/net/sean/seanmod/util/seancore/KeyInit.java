package net.sean.seanmod.util.seancore;

import com.mojang.blaze3d.platform.InputConstants;
import net.sean.seanmod.SeanMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
    private KeyInit(){}

    public static KeyMapping throw_key;

    public static void init(){
        throw_key = registerKey("throw_key", KeyMapping.CATEGORY_GAMEPLAY, InputConstants.KEY_R);
    }
    private static KeyMapping registerKey(String name,  String category,int keyCode){
        final var key = new KeyMapping("key." + SeanMod.modid + "." + name, keyCode,category);
        ClientRegistry.registerKeyBinding(key);
        return key;

    }
}
