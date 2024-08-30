package com.mj.winnie.event;

import com.mj.winnie.Winnie;
import com.mj.winnie.utils.JigsawHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;

/**
 * @author Mike_Chen
 * @date 2022/12/28
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = Winnie.MODID)
public class VillageAddition {
    @SubscribeEvent
    public static void addVillageStructures(FMLServerAboutToStartEvent event) {
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("winnie:village/plains/little_commie_red1"), 12);
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("winnie:village/plains/little_commie_red2"), 12);
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("winnie:village/plains/little_commie_red3"), 15);
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("winnie:village/plains/little_commie_red4"), 12);
        JigsawHelper.registerJigsaw(event.getServer(), new ResourceLocation("minecraft:village/plains/houses"),
                new ResourceLocation("winnie:village/plains/little_commie_red5"), 15);
    }
}
