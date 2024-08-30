package com.mj.winnie.items;

import com.google.common.collect.Sets;
import com.mj.winnie.setup.ModSetup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetheriteSickle extends ToolItem {
    private static final Set<Block> DIGGABLE_BLOCKS = Sets.newHashSet(Blocks.LADDER, Blocks.SCAFFOLDING, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON);

    public NetheriteSickle() {
        super(12, -2.45f, ItemTier.NETHERITE, DIGGABLE_BLOCKS, new Item.Properties()
                .stacksTo(1)
                .tab(ModSetup.ITEM_GROUP));
    }
}
