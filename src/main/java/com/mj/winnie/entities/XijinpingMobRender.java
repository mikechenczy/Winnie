package com.mj.winnie.entities;

import com.mj.winnie.Winnie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

/**
 * @author Mike_Chen
 * @date 2022/12/21
 * @apiNote
 */
@OnlyIn(Dist.CLIENT)
public class XijinpingMobRender extends MobRenderer<XijinpingMobEntity, XijinpingMobModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Winnie.MODID, "textures/entity/xijinpingmob.png");

    public XijinpingMobRender(EntityRendererManager manager) {
        super(manager, new XijinpingMobModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getTextureLocation(XijinpingMobEntity entity) {
        return TEXTURE;
    }
}
