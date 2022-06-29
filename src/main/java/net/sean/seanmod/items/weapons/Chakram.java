package net.sean.seanmod.items.weapons;

import net.sean.seanmod.init.SeanItems;
import net.sean.seanmod.util.materials.SeanArmorMaterials;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Chakram extends SwordItem{

    public Chakram(Tier tier, int i, float v, Properties properties) {
        super(SeanArmorMaterials.DEATH, 13, 1300.0F, properties);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        return super.onDroppedByPlayer(item, player);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return super.hasCustomEntity(stack);
    }

    @Nullable
    @Override
    public Entity createEntity(Level level, Entity location, ItemStack stack) {
        return super.createEntity(level, location, stack);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return super.isRepairable(SeanItems.DARK_SHARD.get().getDefaultInstance());
    }
//private static KeyBinding ActionKey = ;
}
