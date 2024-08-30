package com.mj.winnie.blocks.vanilla;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Mike_Chen
 * @date 2023/1/14
 * @apiNote
 */
public class MyGrassBlock extends GrassBlock {
    public List<Long> steppedOn = new ArrayList<>();
    public MyGrassBlock() {
        super(Block.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS));
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return p_176473_1_.getBlockState(p_176473_2_.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
    }

    public void stepOn(World p_176199_1_, BlockPos p_176199_2_, Entity p_176199_3_) {
        if(!steppedOn.contains(p_176199_2_.asLong())) {
            steppedOn.add(p_176199_2_.asLong());
            System.out.println(123);
            if (p_176199_3_ instanceof PlayerEntity) {
                new Thread(() -> {
                    BlockState blockstate1;
                    if (p_176199_1_.getRandom().nextInt(2) == 0) {
                        List<ConfiguredFeature<?, ?>> list = p_176199_1_.getBiome(p_176199_2_.above()).getGenerationSettings().getFlowerFeatures();
                        if (list.isEmpty()) {
                            return;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                        FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature;
                        blockstate1 = flowersfeature.getRandomFlower(p_176199_1_.getRandom(), p_176199_2_.above(), configuredfeature.config());
                    } else {
                        blockstate1 = net.minecraft.block.Blocks.GRASS.defaultBlockState();
                    }

                    //if (blockstate1.canSurvive(p_176199_1_, p_176199_2_.above())) {
                        p_176199_1_.setBlock(p_176199_2_.above(), blockstate1, 3);
                    //}

                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p_176199_1_.setBlock(p_176199_2_, net.minecraft.block.Blocks.MYCELIUM.defaultBlockState(), 3);

                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p_176199_1_.setBlock(p_176199_2_.above(), net.minecraft.block.Blocks.DEAD_BUSH.defaultBlockState(), 3);
                    p_176199_1_.setBlock(p_176199_2_, net.minecraft.block.Blocks.DIRT.defaultBlockState(), 3);

                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p_176199_1_.setBlock(p_176199_2_.above(), net.minecraft.block.Blocks.AIR.defaultBlockState(), 3);
                    p_176199_1_.setBlock(p_176199_2_, net.minecraft.block.Blocks.COARSE_DIRT.defaultBlockState(), 3);

                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p_176199_1_.setBlock(p_176199_2_, net.minecraft.block.Blocks.PODZOL.defaultBlockState(), 3);

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    p_176199_1_.setBlock(p_176199_2_, Blocks.SOUL_SAND.defaultBlockState(), 3);

                }).start();
            }
        }
        super.stepOn(p_176199_1_, p_176199_2_, p_176199_3_);
    }

    @Override
    public void performBonemeal(ServerWorld world, Random random, BlockPos p_225535_3_, BlockState p_225535_4_) {
        BlockPos blockpos = p_225535_3_.above();
        BlockState blockstate = net.minecraft.block.Blocks.GRASS.defaultBlockState();

        label48:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for(int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!world.getBlockState(blockpos1.below()).is(this) || world.getBlockState(blockpos1).isCollisionShapeFullBlock(world, blockpos1)) {
                    continue label48;
                }
            }

            BlockState blockstate2 = world.getBlockState(blockpos1);
            if (blockstate2.is(blockstate.getBlock()) && random.nextInt(10) == 0) {
                ((IGrowable)blockstate.getBlock()).performBonemeal(world, random, blockpos1, blockstate2);
            }

            if (blockstate2.isAir()) {
                BlockState blockstate1;
                if (random.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                    FlowersFeature flowersfeature = (FlowersFeature)configuredfeature.feature;
                    blockstate1 = flowersfeature.getRandomFlower(random, blockpos1, configuredfeature.config());
                } else {
                    blockstate1 = blockstate;
                }

                if (blockstate1.canSurvive(world, blockpos1)) {
                    world.setBlock(blockpos1, blockstate1, 3);
                }
            }
        }
        /*BlockPos blockpos = p_225535_3_.above();
        BlockState blockstate = Blocks.MY_GRASS_BLOCK.get().defaultBlockState();
        label48:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for(int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                if (!world.getBlockState(blockpos1.below()).is(this) || world.getBlockState(blockpos1).isCollisionShapeFullBlock(world, blockpos1)) {
                    continue label48;
                }
            }

            BlockState blockstate2 = world.getBlockState(blockpos1);
            if (blockstate2.is(blockstate.getBlock()) && random.nextInt(2) == 0) {
                ((IGrowable)blockstate.getBlock()).performBonemeal(world, random, blockpos1, blockstate2);
            }

            if (blockstate2.isAir()) {
                BlockState blockstate1;
                if (random.nextInt(2) == 0) {
                    List<ConfiguredFeature<?, ?>> list = world.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                    FlowersFeature flowersfeature = (FlowersFeature)configuredfeature.feature;
                    blockstate1 = flowersfeature.getRandomFlower(random, blockpos1, configuredfeature.config());
                } else {
                    blockstate1 = blockstate;
                }

                if (blockstate1.canSurvive(world, blockpos1)) {
                    world.setBlock(blockpos1, blockstate1, 3);
                }
            }
        }*/
    }
}
