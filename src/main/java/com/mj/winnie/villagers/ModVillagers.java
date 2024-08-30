package com.mj.winnie.villagers;

import com.google.common.collect.ImmutableSet;
import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Blocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PointOfInterestType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Winnie.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.PROFESSIONS, Winnie.MODID);

    public static final RegistryObject<PointOfInterestType> RUBY_BLOCK_POI = POI_TYPES.register("ruby_block_poi",
            () -> new PointOfInterestType("little_commie_red", ImmutableSet.copyOf(Blocks.RUBY_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> little_commie_red = VILLAGER_PROFESSIONS.register("little_commie_red",
            () -> new VillagerProfession("little_commie_red", RUBY_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class,
                    "registerBlockStates", PointOfInterestType.class).invoke(null, RUBY_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}