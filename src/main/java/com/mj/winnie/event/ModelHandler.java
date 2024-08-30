package com.mj.winnie.event;

import com.mj.winnie.Winnie;
import com.mj.winnie.entities.projectile.RubyArrowRenderer;
import com.mj.winnie.setup.registration.Entities;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Mike_Chen
 * @date 2022/12/29
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModelHandler {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(Entities.RUBY_ARROW.get(), RubyArrowRenderer::new);
    }

}