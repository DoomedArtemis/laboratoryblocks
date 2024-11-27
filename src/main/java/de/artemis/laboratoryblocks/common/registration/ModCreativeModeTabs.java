package de.artemis.laboratoryblocks.common.registration;

import de.artemis.laboratoryblocks.InventoryTab;
import net.minecraft.core.Holder;
import net.minecraft.world.item.CreativeModeTab;

import static de.artemis.laboratoryblocks.common.registration.Registration.CREATIVE_MODE_TABS;

public class ModCreativeModeTabs {

    public static final Holder<CreativeModeTab> INVENTORY_TAB = CREATIVE_MODE_TABS.register("inventory_tab", ModCreativeModeTabs::createInventoryTab);

    private static CreativeModeTab createInventoryTab() {
        CreativeModeTab.Builder builder = new CreativeModeTab.Builder(CreativeModeTab.Row.BOTTOM, -1);
        InventoryTab.createInventoryTab(builder);
        return builder.build();
    }

    public static void register() {
    }
}
