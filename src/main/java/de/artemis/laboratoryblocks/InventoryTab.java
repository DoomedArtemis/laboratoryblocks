package de.artemis.laboratoryblocks;

import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.Registration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

public class InventoryTab {

    public static void createInventoryTab(CreativeModeTab.Builder builder) {
        builder.displayItems((set, out) -> {

            out.acceptAll(Registration.ITEMS.getEntries().stream().map(DeferredHolder::value).map(Item::getDefaultInstance).toList());
            //out.acceptAll(Registration.BLOCKS.getEntries().stream().map(DeferredHolder::value).map(Block::asItem).map(Item::getDefaultInstance).toList());

        });
        builder.icon(() -> ModBlocks.LABORATORY_BLOCK.get().asItem().getDefaultInstance());
        builder.withSearchBar();
        builder.title(Component.translatable("itemGroup.laboratoryblocks"));
    }
}
