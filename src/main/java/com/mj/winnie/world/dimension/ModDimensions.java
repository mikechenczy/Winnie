package com.mj.winnie.world.dimension;

import com.mj.winnie.Winnie;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class ModDimensions {

    public static final RegistryKey<DimensionType> COMMUNISM_DIM_TYPE = RegistryKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(Winnie.MODID, "communismdim"));
    public static final RegistryKey<World> COMMUNISM_DIM = RegistryKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(Winnie.MODID, "communismdim"));
}
