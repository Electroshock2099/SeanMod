package net.sean.seanmod.items.weapons;

import net.sean.seanmod.init.SeanEffects;
import net.sean.seanmod.init.SeanParticles;
import net.sean.seanmod.util.materials.SeanArmorMaterials;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Destroyer_Axe extends AxeItem {
    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        super.onUsingTick(stack, player, count);
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return super.getUseDuration(p_41454_);
        /**double posY = livingEntity.getY();
        double posZ = livingEntity.getZ();
        double posX = livingEntity.getX();
        double posX2 = livingEntity.getX() * livingEntity.getScale();
        level.addParticle(SeanParticles.GHOSTLYFLAMES.get(),posX,posY,posZ,6,6,6
        );**/
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        double posX = player.getX();
        double posY = player.getY();
        double posZ = player.getZ();
        //double posX2 = livingEntity.getX() * livingEntity.getScale();
        level.addParticle(SeanParticles.GHOSTLYFLAMES.get(),posX,posY,posZ,6,6,6
        );
        return super.use(level,player,hand);
    }

    public Destroyer_Axe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(SeanArmorMaterials.DARKNESS, 666,666, (new Item.Properties().fireResistant())
        );
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int p_41415_) {
        super.releaseUsing(itemStack, level, livingEntity, p_41415_);

livingEntity.addEffect(new MobEffectInstance(SeanEffects.GHOSTFLAME.get(), 49));
        //this.canPerformAction(this, ToolActions.SWORD_SWEEP)
    }

}
