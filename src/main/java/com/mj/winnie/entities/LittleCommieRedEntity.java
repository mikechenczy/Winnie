package com.mj.winnie.entities;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mj.winnie.setup.registration.Items;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;
import java.util.Set;

/**
 * @author Mike_Chen
 * @date 2022/12/23
 * @apiNote
 */
public class LittleCommieRedEntity extends AbstractVillagerEntity {
    private static final int NUMBER_OF_TRADE_OFFERS = 2;

    private static final Set<Item> WANTED_ITEMS = ImmutableSet.of(
            Items.RUBY.get()
    );

    public static final Int2ObjectMap<VillagerTrades.ITrade[]> NETHER_LAMBMAN_TRADES = new Int2ObjectOpenHashMap<>(ImmutableMap.of(
            1, new VillagerTrades.ITrade[] {
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 10), new ItemStack(Items.RUBY.get(), 5), 16, 2, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(net.minecraft.item.Items.DIAMOND, 48), new ItemStack(Items.RUBY.get(), 1), 16, 2, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(net.minecraft.item.Items.NETHERITE_INGOT, 32), new ItemStack(Items.RUBY.get(), 1), 16, 2, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 5), new ItemStack(Items.NUCLEIC_ACID_ITEM.get(), 1), 16, 1, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 5), new ItemStack(Items.VACCINE_ITEM.get(), 1), 16, 1, 1.0f);
                        }
                    }
            },
            2, new VillagerTrades.ITrade[] {
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(net.minecraft.item.Items.GOLD_INGOT, 64), new ItemStack(Items.RUBY.get(), 1), 16, 2, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_HELMET.get(), 1), 5, 7, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_BOOTS.get(), 1), 5, 10, 1.0f);
                        }
                    }
            },
            3, new VillagerTrades.ITrade[] {
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_CHESTPLATE.get(), 1), 5, 7, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_LEGGINGS.get(), 1), 5, 10, 1.0f);
                        }
                    },
                    new VillagerTrades.ITrade() {
                        @Nullable
                        @Override
                        public MerchantOffer getOffer(Entity entity, Random rand) {
                            return new MerchantOffer(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_COMMUNIST.get(), 1), 5, 30, 1.0f);
                        }
                    }
            }
    ));

    public LittleCommieRedEntity(EntityType<? extends LittleCommieRedEntity> entityType, World level) {
        super(entityType, level);
        ((GroundPathNavigator)this.getNavigation()).setCanOpenDoors(true);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, AbstractSkeletonEntity.class, 8.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, EvokerEntity.class, 12.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VindicatorEntity.class, 8.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VexEntity.class, 8.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PillagerEntity.class, 15.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, IllusionerEntity.class, 12.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZoglinEntity.class, 10.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(1, new LookAtCustomerGoal(this));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
        this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
    }

    @Override
    @Nullable
    public AgeableEntity getBreedOffspring(@Nonnull ServerWorld level, @Nonnull AgeableEntity mob) {
        return null;
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public boolean wantsToPickUp(ItemStack itemStack) {
        Item item = itemStack.getItem();
        return WANTED_ITEMS.contains(item) && this.getInventory().canAddItem(itemStack);
    }

    @Override
    @Nonnull
    public ActionResultType mobInteract(@Nonnull PlayerEntity player, @Nonnull Hand hand) {
        if (this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (this.getOffers().isEmpty()) {
                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }
            if (!this.level.isClientSide) {
                this.setTradingPlayer(player);
                this.openTradingScreen(player, this.getDisplayName(), 1);
            }

            return ActionResultType.sidedSuccess(this.level.isClientSide);
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public void readAdditionalSaveData(@Nonnull CompoundNBT pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void updateTrades() {
        VillagerTrades.ITrade[] list1 = NETHER_LAMBMAN_TRADES.get(1);
        VillagerTrades.ITrade[] list2 = NETHER_LAMBMAN_TRADES.get(2);
        VillagerTrades.ITrade[] list3 = NETHER_LAMBMAN_TRADES.get(3);
        if (list1 != null && list2 != null) {
            MerchantOffers merchantoffers = this.getOffers();
            this.addOffersFromItemListings(merchantoffers, list1, NUMBER_OF_TRADE_OFFERS);
            int i = this.random.nextInt(list2.length);
            VillagerTrades.ITrade itemListing1 = list2[i];
            int j = this.random.nextInt(list3.length);
            VillagerTrades.ITrade itemListing2 = list3[j];
            MerchantOffer merchantoffer1 = itemListing1.getOffer(this, this.random);
            if (merchantoffer1 != null) {
                merchantoffers.add(merchantoffer1);
            }
            MerchantOffer merchantoffer2 = itemListing2.getOffer(this, this.random);
            if (merchantoffer2 != null) {
                merchantoffers.add(merchantoffer2);
            }
        }
    }

    @Override
    public boolean removeWhenFarAway(double p_35886_) {
        return false;
    }

    @Override
    protected void rewardTradeXp(MerchantOffer offer) {
        if (offer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level.addFreshEntity(new ExperienceOrbEntity(this.level, this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    @Override
    public void setLastHurtByMob(@Nullable LivingEntity entity) {
        if (entity != null && this.level instanceof ServerWorld) {
            if (this.isAlive() && entity instanceof PlayerEntity) {
                for(int i = 0; i < this.getInventory().getContainerSize(); ++i) {
                    ItemStack itemStack = this.getInventory().getItem(i);
                    if(itemStack.getCount() != 0) {
                        int cnt = Math.max(itemStack.getCount(), this.random.nextInt(3));
                        this.level.addFreshEntity(new ItemEntity(
                                this.level, (this.getX() + entity.getX() * 2) / 3, this.getY() + 0.5D, (this.getZ() + entity.getZ() * 2) / 3, new ItemStack(itemStack.getItem(), cnt)
                        ));
                        itemStack.shrink(cnt);
                    }
                }
            }
        }

        super.setLastHurtByMob(entity);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return super.getHurtSound(damageSource);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }

    @Override
    @Nonnull
    protected SoundEvent getTradeUpdatedSound(boolean correct) {
        return super.getTradeUpdatedSound(correct);
        //correct ? ECSounds.NETHER_LAMBMAN_YES : ECSounds.NETHER_LAMBMAN_NO;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }
}