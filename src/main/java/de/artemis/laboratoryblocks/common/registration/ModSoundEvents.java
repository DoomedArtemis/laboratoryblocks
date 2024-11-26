package de.artemis.laboratoryblocks.common.registration;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModSoundEvents {

    public static void register() {
    }

    private static DeferredHolder<SoundEvent, SoundEvent> register(String resourceLocation) {
        return Registration.SOUND_EVENTS.register(resourceLocation,  () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, resourceLocation)));
    }

    public static final DeferredHolder<SoundEvent, SoundEvent> LABORATORY_BLOCK_BREAK = register("laboratory_block_break");
    public static final DeferredHolder<SoundEvent, SoundEvent> LABORATORY_BLOCK_FALL = register("laboratory_block_fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> LABORATORY_BLOCK_HIT = register("laboratory_block_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> LABORATORY_BLOCK_PLACE = register("laboratory_block_place");
    public static final DeferredHolder<SoundEvent, SoundEvent> LABORATORY_BLOCK_STEP = register("laboratory_block_step");
    public static final DeferredHolder<SoundEvent, SoundEvent> CONFIGURATION_TOOL_USE = register("configuration_tool_use");

}
