package de.artemis.laboratoryblocks.common.registration;

import static de.artemis.laboratoryblocks.common.registration.Registration.DATA_COMPONENTS;

import de.artemis.laboratoryblocks.common.items.ConfigurationToolItem;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModDataComponents {

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ConfigurationToolItem.State>> CONFIGURATION_TOOL_STATE = DATA_COMPONENTS.register("configuration_tool_state",
            () -> DataComponentType.<ConfigurationToolItem.State>builder()
            .persistent(ConfigurationToolItem.State.CODEC)
            .networkSynchronized(ConfigurationToolItem.State.STREAM_CODEC)
            .build());

    public static void register() {
    }
}
