package com.mj.winnie.event;

import com.mj.winnie.Winnie;
import com.mj.winnie.setup.registration.Items;
import com.mj.winnie.setup.registration.Structures;
import com.mj.winnie.villagers.ModVillagers;
import net.minecraft.entity.Entity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class VillagerTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.little_commie_red.get()) {
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> trades1 = event.getTrades().get(1);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> trades2 = event.getTrades().get(2);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> trades3 = event.getTrades().get(3);
            List<net.minecraft.entity.merchant.villager.VillagerTrades.ITrade> trades4 = event.getTrades().get(4);
            //trades.add(new BasicTrade(2, new ItemStack(ModItems.SCALLION.get(), 12), 20, 2));
            //trades.add(new BasicTrade(1, new ItemStack(ModItems.SWEET_POTATOES.get(), 6), 20, 2));
            //trades.add(new BasicTrade(1, new ItemStack(ModItems.SOYBEAN.get(), 12), 20, 1));
            //trades.add(new BasicTrade(6, new ItemStack(ModItems.BLACK_TEA_SAPLING.get(), 1), 20, 2));
            //trades.add(new BasicTrade(new ItemStack(ModItems.RICE.get(), 20), new ItemStack(Items.EMERALD, 1), 16, 2, 1.0f));
            //trades.add(new BasicTrade(new ItemStack(ModItems.PEANUT.get(), 20), new ItemStack(Items.EMERALD, 1), 16, 2, 1.0f));
            //trades.add(new BasicTrade(new ItemStack(ModItems.SCALLION.get(), 18), new ItemStack(Items.EMERALD, 1), 16, 2, 1.0f));
            //trades.add(new BasicTrade(new ItemStack(ModItems.SWEET_POTATOES.get(), 10), new ItemStack(Items.EMERALD, 1), 16, 2, 1.0f));
            trades1.add(new BasicTrade(new ItemStack(net.minecraft.item.Items.DIAMOND, 48), new ItemStack(Items.RUBY.get(), 10), 16, 3, 1.0f));
            trades1.add(new BasicTrade(new ItemStack(net.minecraft.item.Items.NETHERITE_INGOT, 32), new ItemStack(Items.RUBY.get(), 10), 16, 3, 1.0f));
            trades1.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 5), new ItemStack(Items.NUCLEIC_ACID_ITEM.get(), 1), 16, 3, 1.0f));
            trades2.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 5), new ItemStack(Items.VACCINE_ITEM.get(), 1), 16, 8, 1.0f));
            trades2.add(new BasicTrade(new ItemStack(net.minecraft.item.Items.EMERALD, 20), new ItemStack(Items.RUBY.get(), 10), 16, 8, 1.0f));
            trades2.add(new BasicTrade(new ItemStack(net.minecraft.item.Items.GOLD_INGOT, 64), new ItemStack(Items.RUBY.get(), 10), 16, 8, 1.0f));
            trades3.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_HELMET.get(), 1), 5, 10, 1.0f));
            trades3.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_BOOTS.get(), 1), 5, 10, 1.0f));
            trades3.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 15), new ItemStack(Items.RUBY_ARROW.get(), 10), 15, 10, 1.0f));
            trades3.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_COMMUNIST.get(), 1), 5, 10, 1.0f));
            trades4.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_CHESTPLATE.get(), 1), 5, 10, 1.0f));
            trades4.add(new BasicTrade(new ItemStack(Items.RUBY.get(), 20), new ItemStack(Items.RUBY_LEGGINGS.get(), 1), 5, 10, 1.0f));
            trades4.add(new ForMapTrade(new ItemStack(Items.RUBY.get(), 15), Structures.TIANANMEN.get(), MapDecoration.Type.MONUMENT, 10, 5));
            trades4.add(new ForMapTrade(new ItemStack(Items.RUBY.get(), 15), Structures.THE_FORBIDDEN_PALACE.get(), MapDecoration.Type.MONUMENT, 10, 5));
            /*Int2ObjectMap<List<VillagerTrades>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUEBERRY.get(), 15);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,10,8,0.02F));*/
        }
    }

    static class ForMapTrade implements net.minecraft.entity.merchant.villager.VillagerTrades.ITrade {
        private final ItemStack cost;
        private final Structure<?> destination;
        private final MapDecoration.Type destinationType;
        private final int maxUses;
        private final int villagerXp;

        public ForMapTrade(ItemStack itemStack, Structure<?> p_i231575_2_, MapDecoration.Type p_i231575_3_, int p_i231575_4_, int p_i231575_5_) {
            this.cost = itemStack;
            this.destination = p_i231575_2_;
            this.destinationType = p_i231575_3_;
            this.maxUses = p_i231575_4_;
            this.villagerXp = p_i231575_5_;
        }

        @Nullable
        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {
            if (!(p_221182_1_.level instanceof ServerWorld)) {
                return null;
            } else {
                ServerWorld serverworld = (ServerWorld)p_221182_1_.level;
                BlockPos blockpos = serverworld.findNearestMapFeature(this.destination, p_221182_1_.blockPosition(), 100, true);
                if (blockpos != null) {
                    ItemStack itemstack = FilledMapItem.create(serverworld, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
                    FilledMapItem.renderBiomePreviewMap(serverworld, itemstack);
                    MapData.addTargetDecoration(itemstack, blockpos, "+", this.destinationType);
                    itemstack.setHoverName(new TranslationTextComponent("filled_map." + this.destination.getFeatureName().toLowerCase(Locale.ROOT)));
                    return new MerchantOffer(this.cost, new ItemStack(net.minecraft.item.Items.COMPASS), itemstack, this.maxUses, this.villagerXp, 0.2F);
                } else {
                    return null;
                }
            }
        }
    }
}