package net.sean.seanmod.event;

import net.sean.seanmod.SeanMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.*;

@Mod.EventBusSubscriber(modid = SeanMod.modid, bus = Bus.FORGE, value = Dist.CLIENT)
public class SeanForgeEvents {
}
