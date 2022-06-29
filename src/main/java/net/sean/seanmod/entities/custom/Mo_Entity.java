package net.sean.seanmod.entities.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;

public class Mo_Entity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public Mo_Entity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class,10.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        //this.goalSelector.addGoal(5, new TemptGoal(this,1.3,new Goal().));
        this.goalSelector.addGoal(6, new HurtByTargetGoal(this).setAlertOthers());
    }

    public static  AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,20.00)
                .add(Attributes.JUMP_STRENGTH,5.00)
                //.add(Attributes.FLYING_SPEED,20.00)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE,20.00)
                .add(Attributes.ATTACK_DAMAGE,1.75f)
                .add(Attributes.ATTACK_SPEED,2.0f)
                .add(Attributes.MOVEMENT_SPEED,7.00f).build();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SCULK_SENSOR_STEP,0.2F,1.0F);
        //;super.playStepSound(pos, state);
    }

    @Override
    protected float getSoundVolume() {
        return 3.0F;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PHANTOM_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ANVIL_DESTROY;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.AMBIENT_BASALT_DELTAS_MOOD;
    }

    private <E extends IAnimatable>PlayState prediacte(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mo.walk",true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mo.idle",true));
        return PlayState.CONTINUE;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    static final int PARENT_AGE_AFTER_BREEDING = 6000;
    private int inLove;
    @javax.annotation.Nullable
    private UUID loveCause;



    protected void customServerAiStep() {
        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        super.customServerAiStep();
    }


    public void aiStep() {
        super.aiStep();
        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level.addParticle(ParticleTypes.FLAME, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        }

    }

    @Override
    public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController(this, "controller",0, this::prediacte));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
