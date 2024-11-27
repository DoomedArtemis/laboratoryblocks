package de.artemis.laboratoryblocks;

import de.artemis.laboratoryblocks.common.registration.Registration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(LaboratoryBlocks.MOD_ID)
public class LaboratoryBlocks {

    public static final String MOD_ID = "laboratoryblocks";

    public LaboratoryBlocks(IEventBus modBus) {
        Registration.register(modBus);
    }
}