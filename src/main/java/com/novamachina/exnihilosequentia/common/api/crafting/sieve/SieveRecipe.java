package com.novamachina.exnihilosequentia.common.api.crafting.sieve;

import com.novamachina.exnihilosequentia.common.api.crafting.RecipeSerializer;
import com.novamachina.exnihilosequentia.common.api.crafting.SerializableRecipe;
import com.novamachina.exnihilosequentia.common.item.mesh.EnumMesh;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SieveRecipe extends SerializableRecipe {
    public static IRecipeType<SieveRecipe> TYPE = IRecipeType.register(Constants.ModIds.EX_NIHILO_SEQUENTIA + ":sieve");
    public static RegistryObject<RecipeSerializer<SieveRecipe>> SERIALIZER;

    private final Ingredient input;
    private final ItemStack drop;
    private final List<MeshWithChance> meshWithChances;
    private final boolean isWaterlogged;
    private final ResourceLocation recipeId;

    public SieveRecipe(ResourceLocation id, Ingredient input, ItemStack drop, List<MeshWithChance> meshWithChances, boolean isWaterlogged) {
        super(drop, TYPE, id);
        this.recipeId = id;
        this.input = input;
        this.drop = drop;
        this.meshWithChances = meshWithChances;
        this.isWaterlogged = isWaterlogged;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public List<MeshWithChance> getMeshWithChances() {
        return meshWithChances;
    }

    @Override
    protected RecipeSerializer getENSerializer() {
        return SERIALIZER.get();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return drop;
    }

    public boolean isWaterlogged() {
        return isWaterlogged;
    }

    public SieveRecipe filterByMesh(EnumMesh meshType, boolean flattenRecipes) {
        List<MeshWithChance> possibleMeshes = meshWithChances.parallelStream()
            .filter(meshWithChance -> {
                if(flattenRecipes) {
                    if(meshWithChance.getMesh().getId() <= meshType.getId()) {
                        return true;
                    }
                } else {
                    if(meshWithChance.getMesh().getId() == meshType.getId()) {
                        return true;
                    }
                }
                return false;
            }).collect(Collectors.toList());
        return new SieveRecipe(recipeId, input, drop, possibleMeshes, isWaterlogged);
    }
}
