package com.mj.winnie.entities;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LittleCommieRedModel<T extends LittleCommieRedEntity> extends PlayerModel<T> {
    public LittleCommieRedModel(float root) {
        super(root, false);
    }
}