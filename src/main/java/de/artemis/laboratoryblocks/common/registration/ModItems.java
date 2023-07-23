package de.artemis.laboratoryblocks.common.registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static void register() {
    }

    public static final RegistryObject<Item> STARCH = Registration.ITEMS.register("starch",
            () -> new Item(new Item.Properties().food(ModFoods.STARCH)));

    public static final RegistryObject<Item> COMPRESSED_STARCH = Registration.ITEMS.register("compressed_starch",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLA_SHEETS = Registration.ITEMS.register("pla_sheets",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_SCREW = Registration.ITEMS.register("iron_screw",
            () -> new Item(new Item.Properties()));
}
