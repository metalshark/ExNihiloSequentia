package com.novamachina.ens.common.block;

import com.novamachina.ens.common.builder.BlockBuilder;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class BaseBlock extends Block {

    private final int                  harvestLevel;
    private final Supplier<TileEntity> tileEntitySupplier;
    private final ToolType             toolType;

    public BaseBlock(BlockBuilder builder) {
        super(builder.getProperties());
        this.tileEntitySupplier = builder.getTileEntitySupplier();
        this.toolType           = builder.getToolType();
        this.harvestLevel       = builder.getHarvestLevel();
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return toolType;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return tileEntitySupplier != null;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        if (tileEntitySupplier == null) {
            return null;
        } else {
            return tileEntitySupplier.get();
        }
    }

}
