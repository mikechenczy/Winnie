package com.mj.winnie.setup;

import com.mj.winnie.Winnie;
import com.mj.winnie.commands.ModCommands;
import com.mj.winnie.data.CapabilityEntityCharge;
import com.mj.winnie.data.ChargeEventHandler;
import com.mj.winnie.entities.LittleCommieRedEntity;
import com.mj.winnie.entities.projectile.RubyArrowEntity;
import com.mj.winnie.setup.registration.Entities;
import com.mj.winnie.setup.registration.Items;
import com.mj.winnie.setup.registration.Registration;
import com.mj.winnie.setup.registration.Structures;
import com.mj.winnie.villagers.ModVillagers;
import com.mj.winnie.world.dimension.TutorialBiomeProvider;
import com.mj.winnie.world.dimension.TutorialChunkGenerator;
import com.mj.winnie.entities.MaozedongMobEntity;
import com.mj.winnie.entities.XijinpingMobEntity;
import com.mj.winnie.network.Networking;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Winnie.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final ItemGroup ITEM_GROUP = new ItemGroup("winnie") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.RUBY_COMMUNIST.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        Networking.registerMessages();
        CapabilityEntityCharge.register();

        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, ChargeEventHandler::onAttachCapabilitiesEvent);
        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onAttackEvent);
        MinecraftForge.EVENT_BUS.addListener(ChargeEventHandler::onDeathEvent);

        DispenserBlock.registerBehavior(Items.RUBY_ARROW.get(), new ProjectileDispenseBehavior() {

            @Override
            protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
                RubyArrowEntity arrowentity = new RubyArrowEntity(worldIn, position.x(), position.y(),
                        position.z());
                arrowentity.setSecondsOnFire(100);
                arrowentity.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
                return arrowentity;
            }
        });

        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(Entities.XIJINPINGMOB.get(), XijinpingMobEntity.prepareAttributes().build());
            GlobalEntityTypeAttributes.put(Entities.MAOZEDONGMOB.get(), MaozedongMobEntity.createAttributes().build());
            GlobalEntityTypeAttributes.put(Entities.LITTLE_COMMIE_RED.get(), LittleCommieRedEntity.createAttributes().build());

            Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(Winnie.MODID, "chunkgen"),
                    TutorialChunkGenerator.CODEC);
            Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(Winnie.MODID, "biomes"),
                    TutorialBiomeProvider.CODEC);

            ModVillagers.registerPOIs();
        });
        Structures.setupStructures();
    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }
}
