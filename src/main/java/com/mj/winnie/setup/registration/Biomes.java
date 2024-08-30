package com.mj.winnie.setup.registration;

import com.mj.winnie.Winnie;
import com.mj.winnie.world.biome.Communism;
import com.mj.winnie.world.biome.ModConfiguredSurfaceBuilders;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Biomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            Winnie.MODID);

    public static RegistryObject<Biome> COMMUNISM = BIOMES.register("communism",
            () -> Communism.makeBiome(() ->  ModConfiguredSurfaceBuilders.RIFT_SURFACE, 0.125f, 0.05f));
}
