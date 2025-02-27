package novamachina.exnihilosequentia.common.compat.crafttweaker.builder;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.impl.predicate.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import novamachina.exnihilosequentia.api.crafting.heat.HeatRecipe;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nonnull;

@ZenRegister
@ZenCodeType.Name("mods.exnihilosequentia.ZenHeatRecipe")
public class ZenHeatRecipe {

    @Nonnull private final HeatRecipe internal;

    private ZenHeatRecipe(@Nonnull final ResourceLocation recipeId) {
        this.internal = new HeatRecipe(recipeId, null, 0);
    }

    @ZenCodeType.Method
    @Nonnull
    public static ZenHeatRecipe builder(@Nonnull final ResourceLocation recipeId) {
        return new ZenHeatRecipe(recipeId);
    }

    @Nonnull
    public HeatRecipe build() {
        return internal;
    }

    @ZenCodeType.Method
    @Nonnull
    public ZenHeatRecipe setAmount(final int amount) {
        internal.setAmount(amount);
        return this;
    }

    @ZenCodeType.Method
    @Nonnull
    public ZenHeatRecipe setBlock(@Nonnull final Block input) {
        internal.setInput(input);
        return this;
    }

    @ZenCodeType.Method
    @Nonnull
    public ZenHeatRecipe setProperties(@Nonnull final StatePropertiesPredicate properties) {
        internal.setProperties(properties.toVanilla());
        return this;
    }
}
