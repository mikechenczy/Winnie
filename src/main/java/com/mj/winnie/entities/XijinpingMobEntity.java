package com.mj.winnie.entities;

import com.mj.winnie.setup.registration.Items;
import com.mj.winnie.setup.registration.Sounds;
import com.mj.winnie.world.dimension.ModDimensions;
import com.mj.winnie.world.dimension.Teleporter;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * @author Mike_Chen
 * @date 2022/12/21
 * @apiNote
 */
public class XijinpingMobEntity extends ZombieEntity {
    public XijinpingMobEntity(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    @Override
    public boolean isUnderWaterConverting() {
        return false;
    }

    @Override
    protected boolean convertsInWater() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        //this.playSound(SoundEvents.VILLAGER_CELEBRATE, this.getSoundVolume(), this.getVoicePitch());
        return Sounds.XIJINPING_AMBIENT.get(this.random.nextInt(26)).get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return Sounds.XIJINPING_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Sounds.XIJINPING_DEATH.get();
    }

    public static AttributeModifierMap.MutableAttribute prepareAttributes() {
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.23F)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.ARMOR, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        World worldIn = player.level;
        BlockPos pos = player.blockPosition();

        if (!worldIn.isClientSide) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();
                if (server != null) {
                    if(player.getItemInHand(hand).getItem() == Items.XIJINPING_ZHONGGUOHUA_DISC.get()) {
                        if (worldIn.dimension() == ModDimensions.COMMUNISM_DIM) {
                            ServerWorld overWorld = server.overworld();
                            if (overWorld != null) {
                                player.changeDimension(overWorld, new Teleporter(pos, false));
                            }
                        } else {
                            ServerWorld kjDim = server.getLevel(ModDimensions.COMMUNISM_DIM);
                            if (kjDim != null) {
                                player.changeDimension(kjDim, new Teleporter(pos, true));
                            }
                        }
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return super.mobInteract(player, hand);
    }
}
