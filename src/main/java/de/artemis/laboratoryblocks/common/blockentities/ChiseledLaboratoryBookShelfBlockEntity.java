package de.artemis.laboratoryblocks.common.blockentities;

import de.artemis.laboratoryblocks.common.registration.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ChiseledLaboratoryBookShelfBlockEntity extends ChiseledBookShelfBlockEntity {

    public ChiseledLaboratoryBookShelfBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.CHISELED_LABORATORY_BOOKSHELF_BLOCK_ENTITY.get();
    }
}
