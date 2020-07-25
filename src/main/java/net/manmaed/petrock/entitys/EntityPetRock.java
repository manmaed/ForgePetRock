package net.manmaed.petrock.entitys;

import net.manmaed.petrock.items.PRItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Created by manmaed on 30/08/2019.
 */
public class EntityPetRock extends TameableEntity {

    public EntityPetRock(EntityType<? extends EntityPetRock> type, World world) {
        super(type, world);
        this.setTamed(false);
    }

    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8F));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1D));

        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
    }

    @Override
    protected void registerData() {
        super.registerData();
    }


    /*protected void registerAttributes()
    {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        if (this.isTamed())
        {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
        }
    }*/



    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        this.playSound(SoundEvents.BLOCK_STONE_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.BLOCK_STONE_BREAK;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.BLOCK_STONE_BREAK;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    public void setTamed(boolean tamed)
    {
        super.setTamed(tamed);

        if (tamed)
        {
            this.getAttribute(Attributes.field_233818_a_).setBaseValue(20.0D);
        } else {
            this.getAttribute(Attributes.field_233818_a_).setBaseValue(1.0D);
        }

    }

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand)
    {
        ItemStack stack = player.getHeldItem(hand);
        if(stack.getItem().equals(Items.NAME_TAG)) {
            this.setCustomName(stack.getDisplayName());
        }
        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !stack.getItem().equals(PRItems.stoneium) && !stack.getItem().equals(PRItems.kibble))
            {
                this.func_233687_w_(!this.func_233685_eM_());
                this.isJumping = false;
                this.navigator.clearPath();
            }
            if(stack.getItem() == PRItems.kibble && getHealth() < 20.0F) {
                if (!player.abilities.isCreativeMode) {
                    stack.shrink(1);
                }
                this.heal(3.0F);
                return ActionResultType.SUCCESS;
            }
        }
        else if (!this.isTamed()) {
            if (stack.getItem() == PRItems.stoneium ){
                if (!player.abilities.isCreativeMode) {
                    stack.shrink(1);
                }

                if (!this.world.isRemote) {
                    if (this.rand.nextInt(3) == 0) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.func_233687_w_(true);
                        this.setHealth(20.0F);
                        this.playTameEffect(true);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.playTameEffect(false);
                        this.world.setEntityState(this, (byte) 6);
                    }
                }

            }
            return ActionResultType.SUCCESS;
        }
        return super.func_230254_b_(player, hand);
    }

    //TODO: Entitiy Breading
    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        EntityPetRock petRock = new EntityPetRock((PREntitys.petrock), this.world);
        UUID uuid = this.getOwnerId();
        if(uuid != null) {
            petRock.setOwnerId(uuid);
            petRock.setTamed(true);

        }
        return petRock;
    }

    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if (!(otherAnimal instanceof EntityPetRock)) {
            return false;
        } else {
            EntityPetRock petRock = (EntityPetRock)otherAnimal;
            if (!petRock.isTamed()) {
                return false;
            } else if (petRock.func_233684_eK_()) {
                return false;
            } else {
                return this.isInLove() && petRock.isInLove();
            }
        }
    }
}