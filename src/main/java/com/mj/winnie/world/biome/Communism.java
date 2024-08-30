package com.mj.winnie.world.biome;

import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

/**
 * @author Mike_Chen
 * @date 2022/12/23
 * @apiNote
 */
public class Communism {
    public static Biome makeBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.plainsSpawns(mobspawninfo$builder);
        DefaultBiomeFeatures.ambientSpawns(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.BLAZE, 100, 7, 10));
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.ZOMBIFIED_PIGLIN, 50, 4, 4));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);

        biomegenerationsettings$builder.addStructureStart(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_SWAMP);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.BURIED_TREASURE);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.VILLAGE_PLAINS);

        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);

        DefaultBiomeFeatures.addDefaultFlowers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultExtraVegetation(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultMushrooms(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOverworldLandMesaStructures(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultUndergroundVariety(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultSoftDisks(biomegenerationsettings$builder);

        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        DefaultBiomeFeatures.addSurfaceFreezing(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.PLAINS).depth(depth).scale(scale)
                .temperature(1.5F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).waterColor(12808120).waterFogColor(12087756)
                        .fogColor(12744124).skyColor(16032991).foliageColorOverride(14759735).grassColorOverride(13255748)
                        .ambientParticle(new ParticleEffectAmbience(ParticleTypes.LAVA, 0.003f))
                        .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST))
                        .build())
                .mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
}
