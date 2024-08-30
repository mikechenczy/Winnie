package com.mj.winnie.world.gen;

import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Blocks;
import com.mj.winnie.setup.registration.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class OreGeneration{

    @SubscribeEvent
    public static void generateOres(final BiomeLoadingEvent event){
        if(!event.getCategory().equals(Biome.Category.NETHER) && !event.getCategory().equals(Biome.Category.THEEND)) {
            generate(event.getGeneration(),OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.RUBY_ORE.get().defaultBlockState(),
                    3,5,15,8);
        }
    }
    private static void generate(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount){
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight,0, maxHeight)))
                        .squared().count(amount));
    }
}