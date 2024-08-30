package com.mj.winnie.datagen;

import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        //lootTables.put(Registration.FIRSTBLOCK.get(), createStandardTable("firstblock", Registration.FIRSTBLOCK.get()));
    }
}
