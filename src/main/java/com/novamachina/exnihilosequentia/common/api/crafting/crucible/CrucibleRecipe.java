package com.novamachina.exnihilosequentia.common.api.crafting.crucible;

import com.novamachina.exnihilosequentia.common.api.crafting.RecipeSerializer;
import com.novamachina.exnihilosequentia.common.api.crafting.SerializableRecipe;
import com.novamachina.exnihilosequentia.common.tileentity.crucible.CrucilbeTypeEnum;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.RegistryObject;

public class CrucibleRecipe extends SerializableRecipe {
    public static IRecipeType<CrucibleRecipe> TYPE = IRecipeType
        .register(Constants.ModIds.EX_NIHILO_SEQUENTIA + ":crucible");
    public static RegistryObject<RecipeSerializer<CrucibleRecipe>> SERIALIZER;
    private final Ingredient input;
    private final int amount;
    private final FluidStack resultFluid;
    private final CrucilbeTypeEnum type;

    public CrucibleRecipe(ResourceLocation id, Ingredient input, int amount, FluidStack fluid, CrucilbeTypeEnum crucibleType) {
        super(null, TYPE, id);
        this.input = input;
        this.amount = amount;
        this.resultFluid = fluid;
        this.type = crucibleType;
    }

    public Ingredient getInput() {
        return input;
    }

    public int getAmount() {
        return amount;
    }

    public FluidStack getResultFluid() {
        return resultFluid;
    }

    public CrucilbeTypeEnum getCrucibleType() {
        return type;
    }

    @Override
    protected RecipeSerializer getENSerializer() {
        return SERIALIZER.get();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
