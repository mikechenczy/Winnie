package com.mj.winnie.setup;

import com.mj.winnie.Winnie;
import com.mj.winnie.client.AfterLivingRenderer;
import com.mj.winnie.client.InWorldRenderer;
import com.mj.winnie.entities.*;
import com.mj.winnie.entities.projectile.RubyArrowRenderer;
import com.mj.winnie.setup.registration.Entities;
import com.mj.winnie.setup.registration.Registration;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Winnie.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(final FMLClientSetupEvent event) {
        //ScreenManager.register(Registration.FIRSTBLOCK_CONTAINER.get(), FirstBlockScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(Entities.XIJINPINGMOB.get(), XijinpingMobRender::new);
        RenderingRegistry.registerEntityRenderingHandler(Entities.MAOZEDONGMOB.get(), MaozedongMobRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(Entities.LITTLE_COMMIE_RED.get(), LittleCommieRedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(Entities.RUBY_ARROW.get(), RubyArrowRenderer::new);
        //MagicRenderer.register();
        MinecraftForge.EVENT_BUS.addListener(InWorldRenderer::render);
        MinecraftForge.EVENT_BUS.addListener(AfterLivingRenderer::render);

        event.enqueueWork(() -> {
            //RenderTypeLookup.setRenderLayer(Registration.COMPLEX_MULTIPART.get(), RenderType.translucent());
        });
    }

    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {
        //event.getItemColors().register((stack, i) -> 0xff0000, Registration.WEIRDMOB_EGG.get());
    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            return;
        }

        //event.addSprite(MagicRenderer.MAGICBLOCK_TEXTURE);
    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(Winnie.MODID)) {
            event.setMaxWidth(200);
        }
    }
}
