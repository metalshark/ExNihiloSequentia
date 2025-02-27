package novamachina.exnihilosequentia.common.compat.jei.hammer;

import mezz.jei.api.gui.ingredient.ITooltipCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import novamachina.exnihilosequentia.api.crafting.hammer.HammerRecipe;
import novamachina.exnihilosequentia.common.utility.StringUtils;

import javax.annotation.Nonnull;
import java.util.List;

public class HammerTooltipCallback implements ITooltipCallback<ItemStack> {
    @Nonnull private final HammerRecipe hammerRecipe;

    public HammerTooltipCallback(@Nonnull final HammerRecipe hammerRecipe) {
        this.hammerRecipe = hammerRecipe;
    }

    @Override
    public void onTooltip(final int slotIndex, final boolean input, @Nonnull final ItemStack ingredient,
                          @Nonnull final List<ITextComponent> tooltip) {
        if (!input) {
            hammerRecipe.getOutput().stream()
                    .filter(stack -> ItemStack.isSame(ingredient, stack.getStack()))
                    .forEach(stack -> tooltip.add(new StringTextComponent(String.format("%s",
                            StringUtils.formatPercent(stack.getChance())))));
        }
    }
}
