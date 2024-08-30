package com.mj.winnie.datagen;

import com.mj.winnie.Winnie;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Winnie.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //singleTexture(Registration.MAGICBLOCK_ITEM.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
        //        "layer0", new ResourceLocation(Winnie.MODID, "item/magicblock_item"));
        //singleTexture(Registration.FIRSTITEM.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
        //        "layer0", new ResourceLocation(Winnie.MODID, "item/firstitem"));
        //withExistingParent(Registration.FIRSTBLOCK_ITEM.get().getRegistryName().getPath(), new ResourceLocation(Winnie.MODID, "block/firstblock"));
    }
}
