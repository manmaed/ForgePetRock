package net.manmaed.petrock.entitys;

import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

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

    private boolean sitting;

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


    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.GENERIC_MAX_HEALTH, 2.0D)
                .add(Attributes.GENERIC_MOVEMENT_SPEED, 0.25D);
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
            this.getAttribute(Attributes.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20.0F);
        } else {
            this.getAttribute(Attributes.GENERIC_MAX_HEALTH).setBaseValue(1.0D);
        }

    }

    public void setSitting(boolean sitting) {
        this.sitting = sitting;
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.getOwnerId() != null) {
            compound.putUniqueId("Owner", this.getOwnerId());
        }

        compound.putBoolean("Sitting", this.sitting);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        UUID uuid;
        if (compound.hasUniqueId("Owner")) {
            uuid = compound.getUniqueId("Owner");
        } else {
            String s = compound.getString("Owner");
            uuid = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s);
        }

        if (uuid != null) {
            try {
                this.setOwnerId(uuid);
                this.setTamed(true);
            } catch (Throwable throwable) {
                this.setTamed(false);
            }
        }

        this.sitting = compound.getBoolean("Sitting");
        this.setSitting(this.sitting);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        Item item = stack.getItem();
        return item.getName().equals(PRItems.kibble);
    }

    public ActionResultType interactMob(PlayerEntity player, Hand hand) {
    ItemStack stack = player.getHeldItem(hand);
        LogHelper.fatal(isOwner(player) + " - " + world.isRemote());
        if(stack.getItem().equals(Items.NAME_TAG)) {
            this.setCustomName(stack.getDisplayName());
        }
        if (this.isTamed()) {
            if (this.isOwner(player) && !world.isRemote()) {
                LogHelper.fatal(isOwner(player) + " - " + world.isRemote());
                if (stack.getItem() == PRItems.kibble && getHealth() < 20.0F) {
                    if (!player.abilities.isCreativeMode) {
                        stack.shrink(1);
                    }
                    this.heal(3.0F);
                    return ActionResultType.SUCCESS;
                } else {
                    LogHelper.fatal(this.isSitting());
                    setSitting(!this.isSitting());
                    isJumping = false;
                    navigator.clearPath();
                    return ActionResultType.SUCCESS;
                }
            }
        }
        else if (!isTamed()) {
            if (stack.getItem() == PRItems.stoneium ){
                if (!player.abilities.isCreativeMode) {
                    stack.shrink(1);
                }

                if (world.isRemote()) {
                    if (rand.nextInt(3) == 0) {
                        setTamedBy(player);
                        navigator.clearPath();
                        setSitting(true);
                        setHealth(20.0F);
                        playTameEffect(true);
                        world.setEntityState(this, (byte) 7);
                        return ActionResultType.PASS;
                    } else {
                        playTameEffect(false);
                        world.setEntityState(this, (byte) 6);
                        return ActionResultType.PASS;
                    }
                }

            }
            return ActionResultType.FAIL;
        }
        return super.interactMob(player, hand);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(ServerWorld serverWorld, AgeableEntity ageable) {
        EntityPetRock petRock = new EntityPetRock((PREntityTypes.PETROCK.get()), this.world);
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
            } else if (petRock.isSitting()) {
                return false;
            } else {
                return this.isInLove() && petRock.isInLove();
            }
        }
    }
}