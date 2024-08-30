package com.mj.winnie.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        /*ShapedRecipeBuilder.shaped(Registration.FIRSTBLOCK.get())
                .pattern("xxx")
                .pattern("x#x")
                .pattern("xxx")
                .define('x', Tags.Items.COBBLESTONE)
                .define('#', Tags.Items.DYES_RED)
                .group("winnie")
                .unlockedBy("cobblestone", InventoryChangeTrigger.Instance.hasItems(Blocks.COBBLESTONE))
                .save(consumer);*/
    }
}
