package novamachina.exnihilosequentia.common.compat.crafttweaker;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.managers.IRecipeManager;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionAddRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import novamachina.exnihilosequentia.api.crafting.fluidontop.FluidOnTopRecipe;
import novamachina.exnihilosequentia.common.compat.crafttweaker.builder.ZenFluidOnTopRecipe;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nonnull;

@ZenRegister
@ZenCodeType.Name("mods.exnihilosequentia.FluidOnTopRecipes")
@SuppressWarnings("unused")
public class FluidOnTopRecipeManager implements IRecipeManager {

    @ZenCodeType.Method
    @Nonnull
    public ZenFluidOnTopRecipe create(@Nonnull String recipeId) {
        recipeId = fixRecipeName(recipeId);
        @Nonnull final ResourceLocation resourceLocation = new ResourceLocation(ExNihiloConstants.ModIds.CRAFT_TWEAKER, recipeId);
        @Nonnull final ZenFluidOnTopRecipe recipe = ZenFluidOnTopRecipe.builder(resourceLocation);
        CraftTweakerAPI.apply(new ActionAddRecipe(this, recipe.build(), ""));
        return recipe;
    }

    @Override
    @Nonnull
    public IRecipeType<FluidOnTopRecipe> getRecipeType() {
        return FluidOnTopRecipe.RECIPE_TYPE;
    }
}
