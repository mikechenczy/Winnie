package com.mj.winnie.setup.registration;

import com.mj.winnie.commands.CommandSpawner;
import com.mj.winnie.entities.LittleCommieRedEntity;
import com.mj.winnie.entities.MaozedongMobEntity;
import com.mj.winnie.entities.XijinpingMobEntity;
import com.mj.winnie.entities.projectile.RubyArrowEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mj.winnie.Winnie.MODID;

/**
 * @author Mike_Chen
 * @date 2022/12/27
 * @apiNote
 */
public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static final RegistryObject<EntityType<MaozedongMobEntity>> MAOZEDONGMOB = ENTITIES.register("maozedongmob", () -> EntityType.Builder.of(MaozedongMobEntity::new, EntityClassification.MONSTER)
            .sized(0.9f, 3.5f)
            .setShouldReceiveVelocityUpdates(false)
            .build("maozedongmob"));
    public static final RegistryObject<EntityType<XijinpingMobEntity>> XIJINPINGMOB = ENTITIES.register("xijinpingmob", () -> EntityType.Builder.of(XijinpingMobEntity::new, EntityClassification.MONSTER)
            .sized(0.6f, 1.95f)
            .setShouldReceiveVelocityUpdates(false)
            .build("xijinpingmob"));
    public static final RegistryObject<EntityType<LittleCommieRedEntity>> LITTLE_COMMIE_RED = ENTITIES.register("little_commie_red", () -> EntityType.Builder.of(LittleCommieRedEntity::new, EntityClassification.CREATURE)
            .sized(0.6f, 1.95f)
            .setShouldReceiveVelocityUpdates(false)
            .build("little_commie_red"));
    public static final RegistryObject<EntityType<RubyArrowEntity>> RUBY_ARROW = ENTITIES.register("ruby_arrow", () -> EntityType.Builder.<RubyArrowEntity>of(RubyArrowEntity::new, EntityClassification.MISC)
            .sized(0.5f, 0.5f)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build("ruby_arrow"));
}
