package com.mj.winnie.entities;

import com.mj.winnie.Winnie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class LittleCommieRedRenderer extends MobRenderer<LittleCommieRedEntity, LittleCommieRedModel<LittleCommieRedEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(Winnie.MODID, "textures/entity/little_commie_red/little_commie_red.png");

    public LittleCommieRedRenderer(EntityRendererManager manager) {
        super(manager, new LittleCommieRedModel<>(0.0F), 0.7F);
    }

    @Override @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull LittleCommieRedEntity entity) { return TEXTURE; }
}