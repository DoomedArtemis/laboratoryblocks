package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.items.ConfigurationToolItem;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModParticles;
import de.artemis.laboratoryblocks.common.registration.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RedstoneControlledLaboratoryBlock extends Block implements BaseLaboratoryBlock {
    private final Supplier<RedstoneControlledLaboratoryBlock> glowstone_block;
    private final Supplier<RedstoneControlledLaboratoryBlock> redstone_block;
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public static final BooleanProperty INVERTED = BooleanProperty.create("inverted");

    public RedstoneControlledLaboratoryBlock(Supplier<RedstoneControlledLaboratoryBlock> glowstone_block, Supplier<RedstoneControlledLaboratoryBlock> redstone_block, Properties properties) {
        super(properties);
        this.glowstone_block = glowstone_block;
        this.redstone_block = redstone_block;
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false).setValue(INVERTED, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Block block, @NotNull BlockPos pNeighborPos, boolean isMoving) {
        boolean inverted = blockState.getValue(INVERTED);
        boolean powered = blockState.getValue(POWERED);
        boolean shouldBePowered = level.hasNeighborSignal(blockPos);

        if (inverted) {
            shouldBePowered = !shouldBePowered;
        }

        if (!level.isClientSide) {
            if (powered != shouldBePowered) {
                if (powered) {
                    level.scheduleTick(blockPos, this, 4);
                } else {
                    level.setBlock(blockPos, blockState.cycle(POWERED), 2);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        boolean inverted = blockState.getValue(INVERTED);
        boolean shouldBePowered = serverLevel.hasNeighborSignal(blockPos);

        if (inverted) {
            shouldBePowered = !shouldBePowered;
        }

        if (blockState.getValue(POWERED) != shouldBePowered) {
            serverLevel.setBlock(blockPos, blockState.cycle(POWERED), 2);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStackInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        {

            // Reversing Redstone Control
            if (itemStackInHand.getItem() instanceof ConfigurationToolItem tool && tool.getState(itemStackInHand) == ConfigurationToolItem.State.REVERSE_REDSTONE_CONTROL && blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("redstone")) {
                level.setBlock(blockPos, blockState.cycle(INVERTED), 2);
                level.scheduleTick(blockPos, this, 4);
                level.blockUpdated(blockPos, blockState.getBlock());

                level.playSound(player, blockPos, ModSoundEvents.CONFIGURATION_TOOL_USE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

                spawnParticles(ModParticles.APPLYING_REDSTONE_PARTICLE.get(), level, blockPos);

                return ItemInteractionResult.SUCCESS;

            }

            ItemInteractionResult result = tryApplyGlowstone(itemStackInHand, blockState, level, blockPos, player, hand, glowstone_block);
            if (result == ItemInteractionResult.SUCCESS) return result;

            //Applying Redstone
            if (itemStackInHand.is(ModItems.REDSTONE_PARTICLES.get()) && !blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("redstone")) {
                if (!player.isCreative()) {
                    itemStackInHand.shrink(1);
                }
                level.setBlock(blockPos, redstone_block.get().defaultBlockState(), 3);
                level.playSound(player, blockPos, SoundEvents.BONE_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                spawnParticles(ModParticles.APPLYING_REDSTONE_PARTICLE.get(), level, blockPos);

                return ItemInteractionResult.SUCCESS;
            }

            // Removing Redstone
            if (itemStackInHand.getItem() instanceof ConfigurationToolItem tool && tool.getState(itemStackInHand) == ConfigurationToolItem.State.REMOVE_REDSTONE && blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("redstone")) {
                if (!player.isCreative()) {
                    if (!player.getInventory().add(new ItemStack(ModItems.REDSTONE_PARTICLES.get()))) {
                        ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 1.0F, blockPos.getZ() + 0.5F, new ItemStack(ModItems.REDSTONE_PARTICLES.get()));
                        itemEntity.setDefaultPickUpDelay();
                        level.addFreshEntity(itemEntity);
                    }

                    itemStackInHand.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                }
                level.setBlock(blockPos, redstone_block.get().defaultBlockState(), 3);
                level.playSound(player, blockPos, SoundEvents.BONE_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.playSound(player, blockPos, ModSoundEvents.CONFIGURATION_TOOL_USE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

                spawnParticles(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), level, blockPos);

                return ItemInteractionResult.SUCCESS;

            }
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED).add(INVERTED);
    }
}
