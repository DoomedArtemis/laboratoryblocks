package de.artemis.laboratoryblocks.common.registration;

import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class ModSoundType {

    public static final SoundType LABORATORY_BLOCK = new DeferredSoundType(1.0F, 1.0F,
            ModSoundEvents.LABORATORY_BLOCK_BREAK,
            ModSoundEvents.LABORATORY_BLOCK_STEP,
            ModSoundEvents.LABORATORY_BLOCK_PLACE,
            ModSoundEvents.LABORATORY_BLOCK_HIT,
            ModSoundEvents.LABORATORY_BLOCK_FALL);
}
