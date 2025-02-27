package novamachina.exnihilosequentia.common.tileentity.barrel.mode;

import net.minecraft.world.World;
import novamachina.exnihilosequentia.common.tileentity.barrel.AbstractBarrelTile;
import novamachina.exnihilosequentia.common.utility.ExNihiloConstants;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockBarrelMode extends AbstractBarrelMode {
    public BlockBarrelMode(@Nonnull final String name) {
        super(name);
    }

    @Override
    public void tick(@Nonnull final AbstractBarrelTile barrelTile) {
        // NOOP
    }

    @Override
    @Nonnull
    public ActionResultType onBlockActivated(@Nonnull final AbstractBarrelTile barrelTile,
                                             @Nonnull final PlayerEntity player, @Nonnull final Hand handIn,
                                             @Nonnull final IFluidHandler fluidHandler,
                                             @Nonnull final IItemHandler itemHandler) {
        @Nullable final World world = barrelTile.getLevel();
        if (world != null) {
            world.addFreshEntity(new ItemEntity(barrelTile.getLevel(), barrelTile.getBlockPos().getX() + 0.5F,
                    barrelTile.getBlockPos().getY() + 0.5F,barrelTile.getBlockPos().getZ() + 0.5F,
                    new ItemStack(barrelTile.getInventory().getStackInSlot(0).getItem())));
        }
        barrelTile.getInventory().setStackInSlot(0, ItemStack.EMPTY);
        barrelTile.setMode(ExNihiloConstants.BarrelModes.EMPTY);
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean canFillWithFluid(@Nonnull final AbstractBarrelTile barrel) {
        return false;
    }

    @Override
    public boolean isEmptyMode() {
        return false;
    }

    @Override
    protected boolean isTriggerItem(@Nonnull final ItemStack stack) {
        return false;
    }

    @Override
    public void read(@Nonnull final CompoundNBT nbt) {
        // NOOP
    }

    @Override
    @Nonnull
    public CompoundNBT write() {
        return new CompoundNBT();
    }

    @Override
    protected void spawnParticle(@Nonnull final AbstractBarrelTile barrelTile) {
        // NOOP
    }

    @Override
    @Nonnull
    public List<ITextComponent> getWailaInfo(@Nonnull final AbstractBarrelTile barrelTile) {
        @Nullable final List<ITextComponent> info = new ArrayList<>();

        info.add(new TranslationTextComponent("waila.barrel.block",
                new TranslationTextComponent(barrelTile.getInventory().getStackInSlot(0).getDescriptionId())));

        return info;
    }

    @Override
    @Nonnull
    public ItemStack handleInsert(@Nonnull final AbstractBarrelTile barrelTile, @Nonnull final ItemStack stack,
                                  final boolean simulate) {
        return stack;
    }
}
