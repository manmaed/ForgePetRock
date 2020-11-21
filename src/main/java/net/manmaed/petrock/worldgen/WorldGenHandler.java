package net.manmaed.petrock.worldgen;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class WorldGenHandler {
    public static ConfiguredFeature<?, ?> PR_UNDERGROUND;

    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

        PR_UNDERGROUND = PRBlocks.STONEIUMOREFEATURES.get()
                .configure(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PRBlocks.stoneiumore.getDefaultState(), PRConfig.STONEIUM_ORE_VAIN_SIZE.get()))
                .decorate(Placement.RANGE.configure(new TopSolidRangeConfig(PRConfig.STONEIUM_ORE_YMIN.get(), PRConfig.STONEIUM_ORE_YMIN.get(), PRConfig.STONEIUM_ORE_YMAX.get())))
                .applyChance(PRConfig.STONEIUM_ORE_CHANCE.get());
        Registry.register(registry, new ResourceLocation(Refs.id,"stoneium_gen_underground"), PR_UNDERGROUND);
    }

    public static void addStuffToBiomes(BiomeLoadingEvent event) {
        RegistryKey<Biome> biome = RegistryKey.of(Registry.BIOME_KEY, event.getName());
        if (PRConfig.ENABLE_WORLD_GEN.get()) {
            if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID) && isValidBiome(event.getCategory())) {
                event.getGeneration().feature(GenerationStage.Decoration.UNDERGROUND_ORES, PR_UNDERGROUND).build();
            }
        }
    }
    private static boolean isValidBiome(Biome.Category biomeCategory) {
        //If this does weird things to unclassified biomes (Category.NONE), then we should also mark that biome as invalid
        return biomeCategory != Biome.Category.THEEND && biomeCategory != Biome.Category.NETHER;
    }
}
