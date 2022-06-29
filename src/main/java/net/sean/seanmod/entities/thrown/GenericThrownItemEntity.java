package net.sean.seanmod.entities.thrown;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;

public class GenericThrownItemEntity extends ThrowableItemProjectile {
    public GenericThrownItemEntity(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
