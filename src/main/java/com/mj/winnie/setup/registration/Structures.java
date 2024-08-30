package com.mj.winnie.setup.registration;

import com.mj.winnie.utils.StructureUtil;
import com.mj.winnie.world.structure.*;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mj.winnie.Winnie.MODID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Structures {
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MODID);
    public static final RegistryObject<Structure<NoFeatureConfig>> TIANANMEN = STRUCTURES.register("tiananmen", TiananmenStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> SOCIAL_CREDIT_TEST = STRUCTURES.register("social_credit_test", SocialCreditTestStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> GREAT_WALL = STRUCTURES.register("great_wall", GreatWallStructure::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> HUNG_PROTESTORS = STRUCTURES.register("hung_protestors", HungProtestors::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> PROTESTORS_TOMBS = STRUCTURES.register("protestors_tombs", ProtestorsTombs::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> PROTESTORS_CAGE = STRUCTURES.register("protestors_cage", ProtestorsCage::new);
    public static final RegistryObject<Structure<NoFeatureConfig>> THE_FORBIDDEN_PALACE = STRUCTURES.register("the_forbidden_palace", TheForbiddenPalaceStructure::new);

    public static void setupStructures() {
        StructureUtil.setupMapSpacingAndLand(TIANANMEN.get(), new StructureSeparationSettings(100, 70, 1206458988), true);
        StructureUtil.setupMapSpacingAndLand(SOCIAL_CREDIT_TEST.get(), new StructureSeparationSettings(15, 6, 1146645788), true);
        StructureUtil.setupMapSpacingAndLand(GREAT_WALL.get(), new StructureSeparationSettings(10, 2, 10058988), true);
        StructureUtil.setupMapSpacingAndLand(HUNG_PROTESTORS.get(), new StructureSeparationSettings(6, 3, 150645888), true);
        StructureUtil.setupMapSpacingAndLand(PROTESTORS_TOMBS.get(), new StructureSeparationSettings(5, 2, 189458988), true);
        StructureUtil.setupMapSpacingAndLand(PROTESTORS_CAGE.get(), new StructureSeparationSettings(7, 1, 14589134), true);
        StructureUtil.setupMapSpacingAndLand(THE_FORBIDDEN_PALACE.get(), new StructureSeparationSettings(800, 550, 53131634), true);
    }
}
