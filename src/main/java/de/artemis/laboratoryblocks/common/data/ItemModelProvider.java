package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, LaboratoryBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STARCH.get());
        simpleItem(ModItems.COMPRESSED_STARCH.get());
        simpleItem(ModItems.PLA_SHEETS.get());
        simpleItem(ModItems.IRON_SCREW.get());
        simpleItem(ModItems.GLOWSTONE_PARTICLES.get());
        simpleItem(ModItems.REDSTONE_PARTICLES.get());
        simpleItem(ModItems.CONFIGURATION_TOOL.get());

        simpleBlock(ModBlocks.PLA_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_PLA_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_pla_block"));
        simpleBlock(ModBlocks.PLA_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_PLA_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_pla_tiles"));
        simpleBlock(ModBlocks.LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_block"));
        simpleBlock(ModBlocks.LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_tiles"));
        simpleBlock(ModBlocks.GRAY_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_GRAY_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_gray_laboratory_tiles"));
        simpleBlock(ModBlocks.MIXED_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_MIXED_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_mixed_laboratory_tiles"));
        simpleBlock(ModBlocks.OAK_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_OAK_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_oak_laboratory_floor"));
        simpleBlock(ModBlocks.SPRUCE_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_SPRUCE_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_spruce_laboratory_floor"));
        simpleBlock(ModBlocks.BIRCH_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_BIRCH_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_birch_laboratory_floor"));
        simpleBlock(ModBlocks.DARK_OAK_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_DARK_OAK_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_dark_oak_laboratory_floor"));
        simpleBlock(ModBlocks.JUNGLE_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_JUNGLE_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_jungle_laboratory_floor"));
        simpleBlock(ModBlocks.ACACIA_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_ACACIA_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_acacia_laboratory_floor"));
        simpleBlock(ModBlocks.MANGROVE_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_MANGROVE_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_mangrove_laboratory_floor"));
        simpleBlock(ModBlocks.CRIMSON_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_CRIMSON_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_crimson_laboratory_floor"));
        simpleBlock(ModBlocks.WARPED_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_WARPED_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_warped_laboratory_floor"));
        simpleBlock(ModBlocks.OAK_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_OAK_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_oak_laboratory_tiles"));
        simpleBlock(ModBlocks.SPRUCE_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_SPRUCE_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_spruce_laboratory_tiles"));
        simpleBlock(ModBlocks.BIRCH_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_BIRCH_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_birch_laboratory_tiles"));
        simpleBlock(ModBlocks.DARK_OAK_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_DARK_OAK_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_dark_oak_laboratory_tiles"));
        simpleBlock(ModBlocks.JUNGLE_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_JUNGLE_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_jungle_laboratory_tiles"));
        simpleBlock(ModBlocks.ACACIA_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_ACACIA_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_acacia_laboratory_tiles"));
        simpleBlock(ModBlocks.MANGROVE_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_MANGROVE_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_mangrove_laboratory_tiles"));
        simpleBlock(ModBlocks.CHERRY_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_CHERRY_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_cherry_laboratory_tiles"));
        simpleBlock(ModBlocks.CHERRY_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_CHERRY_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_cherry_laboratory_floor"));
        simpleBlock(ModBlocks.BAMBOO_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_BAMBOO_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_bamboo_laboratory_tiles"));
        simpleBlock(ModBlocks.BAMBOO_LABORATORY_FLOOR.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_BAMBOO_LABORATORY_FLOOR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_bamboo_laboratory_floor"));
        simpleBlock(ModBlocks.CRIMSON_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_CRIMSON_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_crimson_laboratory_tiles"));
        simpleBlock(ModBlocks.WARPED_LABORATORY_TILES.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_WARPED_LABORATORY_TILES.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_warped_laboratory_tiles"));
        simpleBlock(ModBlocks.LABORATORY_GLASS.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_GLASS.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_glass_inventory"));
        simpleBlock(ModBlocks.LABORATORY_FAN.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_FAN.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_fan"));
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_fan_redstone_controlled"));
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_FAN_REDSTONE_CONTROLLED.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_fan_redstone_controlled"));
        simpleBlock(ModBlocks.SCREWED_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_SCREWED_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_screwed_laboratory_block"));
        simpleBlock(ModBlocks.LABORATORY_VENT.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_VENT.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_vent"));
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.LABORATORY_VENT_CONNECTING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_vent"));
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_VENT_CONNECTING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_vent"));
        simpleBlock(ModBlocks.CLEAR_LABORATORY_SCREEN.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_CLEAR_LABORATORY_SCREEN.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_clear_laboratory_screen"));

        simpleBlock(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_left-faced_blue_signaling_laboratory_block"));
        simpleBlock(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_right-faced_blue_signaling_laboratory_block"));
        simpleBlock(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_left-faced_red_signaling_laboratory_block"));
        simpleBlock(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_right-faced_red_signaling_laboratory_block"));
        simpleBlock(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_left-faced_green_signaling_laboratory_block"));
        simpleBlock(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_right-faced_green_signaling_laboratory_block"));

        simpleBlock(ModBlocks.LABORATORY_PILLAR.get());
        cubeColumn(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_PILLAR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_pillar"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_pillar_top"));
        simpleBlock(ModBlocks.GRAY_LABORATORY_PILLAR.get());
        cubeColumn(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_GRAY_LABORATORY_PILLAR.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_gray_laboratory_pillar"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_gray_laboratory_pillar_top"));
        simpleBlock(ModBlocks.LABORATORY_BOOKSHELF.get());
        cubeColumn(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_LABORATORY_BOOKSHELF.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_bookshelf"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_laboratory_bookshelf_top"));

        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_block"));
        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_pla_block"));
        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.TILED_PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_tiles"));
        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.ENLIGHTED_TILED_PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/enlighted_pla_tiles"));

    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", ResourceLocation.fromNamespaceAndPath(this.modid, "item/" +
                DataProvider.getRawRegistryName(item)));
    }

    private void simpleBlock(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), ResourceLocation.fromNamespaceAndPath(this.modid, "block/" + DataProvider.getRawRegistryName(block)));
    }
}
