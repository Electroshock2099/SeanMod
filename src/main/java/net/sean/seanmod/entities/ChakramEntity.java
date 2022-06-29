package net.sean.seanmod.entities;

import net.sean.seanmod.init.SeanEntities;
import net.sean.seanmod.init.SeanItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class ChakramEntity extends AbstractArrow implements ItemSupplier{//GenericThrownItemEntity {
    /**public ChakramEntity(PlayMessages.SpawnEntity packet, Level world) {
        super((EntityType) SeanEntities.CHAKRAM_ENTITY, world);
    }**/

    public ChakramEntity(EntityType<? extends ChakramEntity> type, Level world) {
        super(type, world);
    }

    public ChakramEntity(EntityType<? extends ChakramEntity> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public ChakramEntity(EntityType<? extends ChakramEntity> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    public Packet<?> m_5654_() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }



    @OnlyIn(Dist.CLIENT)
    public ItemStack getPickupItem() {
        return new ItemStack((ItemLike) SeanItems.CHAKRAM.get());
    }

    public ItemStack getItem() {
        return new ItemStack(SeanItems.CHAKRAM.get());
    }
/**
    protected void m_7761_(LivingEntity entity) {
        super.m_7761_(entity);
        entity.m_21317_(entity.m_21234_() - 1);
    }

    public void m_8119_() {
        super.m_8119_();
        if (this.f_36703_)
            m_146870_();
    }

    public static ChakramEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {**/
        //ChakramEntity entityarrow = new ChakramEntity((EntityType<? extends ChakramEntity>)SeanEntities.CHAKRAM_ENTITY.get(), entity, world);
       /** entityarrow.m_6686_((entity.m_20252_(1.0F)).f_82479_, (entity.m_20252_(1.0F)).f_82480_, (entity.m_20252_(1.0F)).f_82481_, power * 2.0F, 0.0F);
        entityarrow.m_20225_(true);
        entityarrow.m_36762_(false);
        entityarrow.m_36781_(damage);
        entityarrow.m_36735_(knockback);
        world.m_7967_((Entity)entityarrow);
        world.m_6263_(null, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (SoundEvent) ForgeRegistries.SOUND_EVENTS
                .getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F / (random
                .nextFloat() * 0.5F + 1.0F) + power / 2.0F);
        return entityarrow;
    }

    public static ChakramEntity shoot(LivingEntity entity, LivingEntity target) {**/
        //ChakramEntity entityarrow = new ChakramEntity((EntityType<? extends ChakramEntity>)SeanEntities.CHAKRAM_ENTITY, entity, entity.f_19853_);
       /** double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getYRot() - 1.1D;
        double dz = target.getZ() - entity.getZ();
        entityarrow.m_6686_(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224D, dz, 6.0F, 12.0F);
        entityarrow.m_20225_(true);
        entityarrow.m_36781_(5.5D);
        entityarrow.m_36735_(7);
        entityarrow.m_36762_(false);
        entity.f_19853_.m_7967_((Entity)entityarrow);
        entity.f_19853_.m_6263_(null, entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS
                .getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1.0F, 1.0F / ((new Random())
                .nextFloat() * 0.5F + 1.0F));
        return entityarrow;
    }**/


}
