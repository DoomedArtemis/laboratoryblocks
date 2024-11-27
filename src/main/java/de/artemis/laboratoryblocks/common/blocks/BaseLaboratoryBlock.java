package de.artemis.laboratoryblocks.common.blocks;

import java.util.function.Supplier;

import de.artemis.laboratoryblocks.common.items.ConfigurationToolItem;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModParticles;
import de.artemis.laboratoryblocks.common.registration.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public interface BaseLaboratoryBlock {

    public default void spawnParticles(ParticleOptions particle, Level level, BlockPos blockPos) {
        for (float i = 0; i <= 1; i += 0.2F) {
            level.addParticle(particle, blockPos.getX() + i, blockPos.getY(), blockPos.getZ(), 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ(), 0, 0, 0);
            level.addParticle(particle, blockPos.getX(), blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + i, blockPos.getY(), blockPos.getZ() + 1, 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ() + 1, 0, 0, 0);
            level.addParticle(particle, blockPos.getX(), blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
            level.addParticle(particle, blockPos.getX(), blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + 1, blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
            level.addParticle(particle, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
            level.addParticle(particle, blockPos.getX() + 1, blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
        }
    }

    public default BlockState copyState(BlockState oldState, BlockState newState) {
        return newState;
    }

    @SuppressWarnings("deprecation")
    public default ItemInteractionResult tryApplyGlowstone(ItemStack itemStackInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, Supplier<? extends Block> glowstone_block) {
        // Applying Glowstone
        if (itemStackInHand.is(ModItems.GLOWSTONE_PARTICLES.get()) && !blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("enlighted")) {
            if (!player.isCreative()) {
                itemStackInHand.shrink(1);
            }
            level.setBlock(blockPos, copyState(blockState, glowstone_block.get().defaultBlockState()), 3);
            level.playSound(player, blockPos, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);

            spawnParticles(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), level, blockPos);

            return ItemInteractionResult.SUCCESS;
        }

        // Removing Glowstone
        if (itemStackInHand.getItem() instanceof ConfigurationToolItem tool && tool.getState(itemStackInHand) == ConfigurationToolItem.State.REMOVE_GLOWSTONE && blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("enlighted")) {
            if (!player.isCreative()) {
                if (!player.getInventory().add(new ItemStack(ModItems.GLOWSTONE_PARTICLES.get()))) {
                    ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 1.0F, blockPos.getZ() + 0.5F, new ItemStack(ModItems.GLOWSTONE_PARTICLES.get()));
                    itemEntity.setDefaultPickUpDelay();
                    level.addFreshEntity(itemEntity);
                }

                itemStackInHand.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            }
            level.setBlock(blockPos, copyState(blockState, glowstone_block.get().defaultBlockState()), 3);
            level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.playSound(player, blockPos, ModSoundEvents.CONFIGURATION_TOOL_USE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

            spawnParticles(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), level, blockPos);

            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
