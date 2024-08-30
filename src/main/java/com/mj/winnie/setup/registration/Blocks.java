package com.mj.winnie.setup.registration;

import com.mj.winnie.blocks.vanilla.MyGrassBlock;
import com.mj.winnie.blocks.RubyBlock;
import com.mj.winnie.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mj.winnie.Winnie.MODID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Blocks {
    public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<RubyOre> RUBY_ORE = BLOCKS.register("ruby_ore", RubyOre::new);
    public static final RegistryObject<RubyBlock> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    //public static final RegistryObject<MyGrassBlock> MY_GRASS_BLOCK = VANILLA_BLOCKS.register("grass_block", MyGrassBlock::new);

}
