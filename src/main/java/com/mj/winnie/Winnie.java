package com.mj.winnie;

import com.mj.winnie.setup.ClientSetup;
import com.mj.winnie.setup.Config;
import com.mj.winnie.setup.ModSetup;
import com.mj.winnie.setup.registration.*;
import com.mj.winnie.utils.JigsawHelper;
import com.mj.winnie.villagers.ModVillagers;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Winnie.MODID)
public class Winnie {

    public static final String MODID = "winnie";

    public static final Logger LOGGER = LogManager.getLogger();

    public Winnie() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Blocks.VANILLA_BLOCKS.register(bus);
        Blocks.BLOCKS.register(bus);
        Items.VANILLA_ITEMS.register(bus);
        Items.ITEMS.register(bus);
        //TILES.register(bus);
        //CONTAINERS.register(bus);
        Entities.ENTITIES.register(bus);
        Sounds.SOUNDS.register(bus);
        Structures.STRUCTURES.register(bus);
        Biomes.BIOMES.register(bus);
        ModVillagers.POI_TYPES.register(bus);
        ModVillagers.VILLAGER_PROFESSIONS.register(bus);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
