package com.mj.winnie.entities.projectile;

import com.mj.winnie.Winnie;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpectralArrowRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author Mike_Chen
 * @date 2022/12/29
 * @apiNote
 */
@OnlyIn(Dist.CLIENT)
public class RubyArrowRenderer extends ArrowRenderer<RubyArrowEntity> {
    public static final ResourceLocation RUBY_ARROW_LOCATION = new ResourceLocation("textures/entity/projectiles/spectral_arrow.png");

    public RubyArrowRenderer(EntityRendererManager p_i46193_1_) {
        super(p_i46193_1_);
    }

    @Override
    public ResourceLocation getTextureLocation(RubyArrowEntity entity) {
        return RUBY_ARROW_LOCATION;
    }
}
