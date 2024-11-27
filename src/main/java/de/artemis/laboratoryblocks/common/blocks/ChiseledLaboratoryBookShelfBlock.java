package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.blockentities.ChiseledLaboratoryBookShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ChiseledLaboratoryBookShelfBlock extends ChiseledBookShelfBlock implements BaseLaboratoryBlock {

    private final Supplier<ChiseledLaboratoryBookShelfBlock> block;

    public ChiseledLaboratoryBookShelfBlock(Supplier<ChiseledLaboratoryBookShelfBlock> block, Properties properties) {
        super(properties);
        this.block = block;
    }

    @Override
    public BlockState copyState(BlockState oldState, BlockState newState) {
        return newState.setValue(HorizontalDirectionalBlock.FACING, oldState.getValue(HorizontalDirectionalBlock.FACING))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED))
                .setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED, oldState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED));
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (newState.getBlock() instanceof ChiseledLaboratoryBookShelfBlock) return;
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStackInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        //Vanilla Begin

        ItemInteractionResult result = super.useItemOn(itemStackInHand, blockState, level, blockPos, player, hand, hitResult);
        if (result != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION)
            return result;

        //Vanilla End

        result = tryApplyGlowstone(itemStackInHand, blockState, level, blockPos, player, hand, block);

        return result;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ChiseledLaboratoryBookShelfBlockEntity(blockPos, blockState);
    }
}
