package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = LaboratoryBlocks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataProvider {

    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> future = event.getLookupProvider();

        generator.addProvider(true, new ModelAndBlockStateProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(true, new ItemModelProvider(generator.getPackOutput(), existingFileHelper));
        generator.addProvider(true, new LanguageProvider(generator.getPackOutput(), "en_us"));
        generator.addProvider(true, new BlockLootTablesProvider(generator.getPackOutput(), future));
        generator.addProvider(true, new RecipesProvider(generator.getPackOutput(), future));
        generator.addProvider(true, new TagsProvider.BlockTagsProvider(generator.getPackOutput(), future, existingFileHelper));
        generator.addProvider(true, new TagsProvider.ItemTagsProvider(generator.getPackOutput(), future, existingFileHelper));
        generator.addProvider(true, new FusionModelProvider(generator.getPackOutput()));
    }

    @SuppressWarnings("deprecation")
    public static String getRegistryName(Item item) {
        return item.builtInRegistryHolder().key().location().toString();
    }

    @SuppressWarnings("deprecation")
    public static String getRegistryName(Block block) {
        return block.builtInRegistryHolder().key().location().toString();
    }

    @SuppressWarnings("deprecation")
    public static String getRawRegistryName(Item item) {
        return item.builtInRegistryHolder().key().location().getPath().toString();
    }

    @SuppressWarnings("deprecation")
    public static String getRawRegistryName(Block block) {
        return block.builtInRegistryHolder().key().location().getPath().toString();
    }
}
