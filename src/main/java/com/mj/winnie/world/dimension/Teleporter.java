package com.mj.winnie.world.dimension;

import com.mj.winnie.Winnie;
import com.mj.winnie.data.ModSavedData;
import com.mj.winnie.entities.XijinpingMobEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.CryingObsidianBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.items.IItemHandler;

import java.util.function.Function;

public class Teleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public Teleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 63;
        while (!(destinationWorld.isEmptyBlock(new BlockPos(thisPos.getX(), y, thisPos.getZ())) &&
                destinationWorld.isEmptyBlock(new BlockPos(thisPos.getX(), y+1, thisPos.getZ())))) {
            y++;
        }

        //if (!insideDimension) {
        //    y = thisPos.getY();
        //}

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        /*int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }*/

        entity.setPosAndOldPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof GrassBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlock(destinationPos, Blocks.GRASS_BLOCK.defaultBlockState(), 1);
            }
            if(entity instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity) entity).setRespawnPosition(destinationWorld.dimension(), destinationPos, 0.0F, true, false);
                //ModSavedData.getData(destinationWorld).DATA.clear();
                //Winnie.LOGGER.debug("FUCKING SAVED DATA");
                //entity.getPersistentData().putLong("dim_respawn_pos", destinationPos.asLong());
                //ModSavedData.putData(new ModSavedData.ModSavedObject(destinationWorld.random.nextInt(), destinationPos, entity.getUUID()), destinationWorld);
            }
        }

        return entity;
    }
}