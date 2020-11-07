package com.novamachina.exnihilosequentia.common.api.crafting.heat;

import com.novamachina.exnihilosequentia.common.api.crafting.ExNihiloFinishedRecipe;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.Ingredient;

public class HeatRecipeBuilder extends ExNihiloFinishedRecipe<HeatRecipeBuilder> {
    private HeatRecipeBuilder() {
        super(HeatRecipe.SERIALIZER.get());
    }

    public static HeatRecipeBuilder builder() {
        return new HeatRecipeBuilder();
    }

    public HeatRecipeBuilder input(Ingredient input) {
        return this.addInput(input);
    }

    public HeatRecipeBuilder amount(int amount) {
        return addWriter(jsonObj -> jsonObj.addProperty("amount", amount));
    }

    public HeatRecipeBuilder input(Block block) {
        return this.addBlock(block);
    }
}
