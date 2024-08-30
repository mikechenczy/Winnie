package com.mj.winnie.world.gen;

import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Biomes;
import com.mj.winnie.setup.registration.Registration;
import com.mj.winnie.setup.registration.Structures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

/**
 * @author Mike_Chen
 * @date 2022/12/21
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class StructureGeneration {

    @SubscribeEvent
    public static void generateTiananmen(final BiomeLoadingEvent event) {
        if(event.getCategory() == Biome.Category.THEEND || event.getCategory() == Biome.Category.NETHER)
            return;
        if(event.getCategory() == Biome.Category.OCEAN)
            return;
        event.getGeneration().getStructures().add(() -> Structures.TIANANMEN.get().configured(IFeatureConfig.NONE));
    }

    @SubscribeEvent
    public static void generateCommunismSpecial(final BiomeLoadingEvent event) {
        if(event.getName()==null)
            return;
        if(!event.getName().toString().equals("winnie:communism"))
            return;
        event.getGeneration().getStructures().add(() -> Structures.SOCIAL_CREDIT_TEST.get().configured(IFeatureConfig.NONE));
        event.getGeneration().getStructures().add(() -> Structures.GREAT_WALL.get().configured(IFeatureConfig.NONE));
        event.getGeneration().getStructures().add(() -> Structures.HUNG_PROTESTORS.get().configured(IFeatureConfig.NONE));
        event.getGeneration().getStructures().add(() -> Structures.PROTESTORS_TOMBS.get().configured(IFeatureConfig.NONE));
        event.getGeneration().getStructures().add(() -> Structures.PROTESTORS_CAGE.get().configured(IFeatureConfig.NONE));
        event.getGeneration().getStructures().add(() -> Structures.THE_FORBIDDEN_PALACE.get().configured(IFeatureConfig.NONE));
    }
}
