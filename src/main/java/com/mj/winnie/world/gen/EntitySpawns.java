package com.mj.winnie.world.gen;

import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Entities;
import com.mj.winnie.setup.registration.Registration;
import com.mj.winnie.world.structure.TiananmenStructure;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Mike_Chen
 * @date 2022/12/21
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class EntitySpawns {

    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        if(event.getName() == null)
            return;
        if(event.getName().toString().equals("winnie:communism")) {
            event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(Entities.XIJINPINGMOB.get(), 80, 15, 30));
            return;
        }
        if(event.getCategory() != Biome.Category.OCEAN) {
            event.getSpawns().addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(Entities.XIJINPINGMOB.get(), 10, 3, 10));
        }
    }

    @SubscribeEvent
    public static void onStructureLoad(final StructureSpawnListGatherEvent event) {
        if(event.getStructure() instanceof TiananmenStructure) {
            event.addEntitySpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(Entities.XIJINPINGMOB.get(), 30, 10, 20));
        }
        //if(event.getStructure() == Structure.VILLAGE) {
        //    event.addEntitySpawn(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(Entities.LITTLE_COMMIE_RED.get(), 3, 3, 10));
        //}
    }
}
