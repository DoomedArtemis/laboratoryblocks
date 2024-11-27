package de.artemis.laboratoryblocks.common.event;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.client.particle.custom.ApplyingGlowstoneParticle;
import de.artemis.laboratoryblocks.client.particle.custom.ApplyingRedstoneParticle;
import de.artemis.laboratoryblocks.client.particle.custom.RemovingModifierParticle;
import de.artemis.laboratoryblocks.common.registration.ModParticles;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = LaboratoryBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void registerParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), ApplyingGlowstoneParticle.Provider::new);
        event.registerSpriteSet(ModParticles.APPLYING_REDSTONE_PARTICLE.get(), ApplyingRedstoneParticle.Provider::new);
        event.registerSpriteSet(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), RemovingModifierParticle.Provider::new);
    }
}
