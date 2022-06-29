package net.sean.seanmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class Dark_ShardBlock extends Block {
    public Dark_ShardBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {
        // Server: Main Hand & Off Hand
        // Client: Main Hand & Off Hand

        //player.sendMessage(Component.nullToEmpty("Right Clicked this!"),);
    //TextComponent.
        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
if(entity instanceof LivingEntity livingEntity){
    if(entity instanceof Player player) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 2));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 13));
    }
        //livingEntity.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 300));
        //livingEntity.
    //}
}
        super.stepOn(level, pos, state, entity);
    }
}
