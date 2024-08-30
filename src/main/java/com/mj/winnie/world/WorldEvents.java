package com.mj.winnie.world;

import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Registration;
import com.mj.winnie.setup.registration.Structures;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mike_Chen
 * @date 2022/12/21
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class WorldEvents {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void addDimensionSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) event.getWorld();
            ChunkGenerator chunkGenerator = serverWorld.getChunkSource().getGenerator();

            if (chunkGenerator instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD)) return;

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(Structures.TIANANMEN.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.TIANANMEN.get()));
            tempMap.putIfAbsent(Structures.SOCIAL_CREDIT_TEST.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.SOCIAL_CREDIT_TEST.get()));
            tempMap.putIfAbsent(Structures.GREAT_WALL.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.GREAT_WALL.get()));
            tempMap.putIfAbsent(Structures.HUNG_PROTESTORS.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.HUNG_PROTESTORS.get()));
            tempMap.putIfAbsent(Structures.PROTESTORS_TOMBS.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.PROTESTORS_TOMBS.get()));
            tempMap.putIfAbsent(Structures.PROTESTORS_CAGE.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.PROTESTORS_CAGE.get()));
            tempMap.putIfAbsent(Structures.THE_FORBIDDEN_PALACE.get(), DimensionStructuresSettings.DEFAULTS.get(Structures.THE_FORBIDDEN_PALACE.get()));
            chunkGenerator.getSettings().structureConfig = tempMap;
        }
    }
}
