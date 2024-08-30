package com.mj.winnie.items;

import com.mj.winnie.entities.projectile.RubyArrowEntity;
import com.mj.winnie.entities.projectile.RubyArrowRenderer;
import com.mj.winnie.setup.registration.Entities;
import com.mj.winnie.setup.registration.Items;
import net.minecraft.client.renderer.entity.SpectralArrowRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpectralArrowItem;
import net.minecraft.world.World;

/**
 * @author Mike_Chen
 * @date 2022/12/29
 * @apiNote
 */
public class RubyArrowItem extends ArrowItem {
    public final float damage;
    public RubyArrowItem(Properties properties, float damage) {
        super(properties);
        this.damage = damage;
    }

    public AbstractArrowEntity createArrow(World world, ItemStack itemStack, LivingEntity entity) {
        SpectralArrowEntity arrowEntity = new SpectralArrowEntity(world, entity);
        arrowEntity.setBaseDamage(damage);
        return arrowEntity;
    }
}
