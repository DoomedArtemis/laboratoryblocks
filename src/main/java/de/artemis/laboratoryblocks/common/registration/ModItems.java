package de.artemis.laboratoryblocks.common.registration;

import de.artemis.laboratoryblocks.common.items.ConfigurationToolItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItems {

    public static void register() {
    }

    public static final DeferredHolder<Item, Item> STARCH = Registration.ITEMS.register("starch",
            () -> new Item(new Item.Properties().food(ModFoods.STARCH)));

    public static final DeferredHolder<Item, Item> COMPRESSED_STARCH = Registration.ITEMS.register("compressed_starch",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PLA_SHEETS = Registration.ITEMS.register("pla_sheets",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> IRON_SCREW = Registration.ITEMS.register("iron_screw",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> GLOWSTONE_PARTICLES = Registration.ITEMS.register("glowstone_particles",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> REDSTONE_PARTICLES = Registration.ITEMS.register("redstone_particles",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, ConfigurationToolItem> CONFIGURATION_TOOL = Registration.ITEMS.register("configuration_tool",
            () -> new ConfigurationToolItem(new Item.Properties().durability(640).rarity(Rarity.UNCOMMON)));
}
