package com.mj.winnie.entities;

import com.mj.winnie.Winnie;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EnergyLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MaozedongMobRenderer extends MobRenderer<MaozedongMobEntity, MaozedongMobModel<MaozedongMobEntity>> {
    private static final ResourceLocation WITHER_INVULNERABLE_LOCATION = new ResourceLocation(Winnie.MODID,"textures/entity/maozedong/maozedong_invulnerable.png");
    private static final ResourceLocation WITHER_LOCATION = new ResourceLocation(Winnie.MODID,"textures/entity/maozedong/maozedong.png");

    public MaozedongMobRenderer(EntityRendererManager p_i46130_1_) {
        super(p_i46130_1_, new MaozedongMobModel<>(0.0F), 1.0F);
        this.addLayer(new MaozedongAuraLayer(this));
    }

    protected int getBlockLightLevel(MaozedongMobEntity p_225624_1_, BlockPos p_225624_2_) {
        return 15;
    }

    public ResourceLocation getTextureLocation(MaozedongMobEntity p_110775_1_) {
        int i = p_110775_1_.getInvulnerableTicks();
        return i > 0 && (i > 80 || i / 5 % 2 != 1) ? WITHER_INVULNERABLE_LOCATION : WITHER_LOCATION;
    }

    protected void scale(MaozedongMobEntity p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        float f = 2.0F;
        int i = p_225620_1_.getInvulnerableTicks();
        if (i > 0) {
            f -= ((float)i - p_225620_3_) / 220.0F * 0.5F;
        }

        p_225620_2_.scale(f, f, f);
    }

    public static class MaozedongAuraLayer extends EnergyLayer<MaozedongMobEntity, MaozedongMobModel<MaozedongMobEntity>> {
        private static final ResourceLocation WITHER_ARMOR_LOCATION = new ResourceLocation(Winnie.MODID,"textures/entity/maozedong/maozedong_armor.png");
        private final MaozedongMobModel<MaozedongMobEntity> model = new MaozedongMobModel<>(0.5F);

        public MaozedongAuraLayer(IEntityRenderer<MaozedongMobEntity, MaozedongMobModel<MaozedongMobEntity>> p_i50915_1_) {
            super(p_i50915_1_);
        }

        protected float xOffset(float p_225634_1_) {
            return MathHelper.cos(p_225634_1_ * 0.02F) * 3.0F;
        }

        protected ResourceLocation getTextureLocation() {
            return WITHER_ARMOR_LOCATION;
        }

        protected EntityModel<MaozedongMobEntity> model() {
            return this.model;
        }
    }

}