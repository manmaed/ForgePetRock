package net.manmaed.petrock.worldgen;

/**
 * Created by manmaed on 06/12/2019.
 */
public class OreGen {


   /* // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig stoneium_cfg = new CountRangeConfig(100,10,0,128);
    private static final int stoneium_veinsise = 10;

    public static void setupOreGen() {
        for (Biome biome: ForgeRegistries.BIOMES.getValues()) {
            // we have no End ores, so skip those.
            if (biome.getCategory() == Biome.Category.THEEND) {
                continue;
            }
            // Nether Ore generation.
            if (biome.getCategory() == Biome.Category.NETHER) {
                continue;
            }
            //OverWold Generation
            if (CommonConfig.get().enableStoneiumGen.get()) {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        PRBlocks.stoneiumore.getDefaultState(),
                                        stoneium_veinsise),
                                Placement.COUNT_RANGE,
                                stoneium_cfg));
            }

        }
    }*/
}
