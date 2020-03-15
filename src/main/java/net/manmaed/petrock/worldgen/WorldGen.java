package net.manmaed.petrock.worldgen;

/**
 * Created by manmaed on 29/11/2019.
 */
public class WorldGen {

    //private WorldGenMinable stoneiumgen;
    //private Worldgen




   /* @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, ChunkGenerator chunkGenerator, AbstractChunkProvider chunkProvider) {
        int ChunkX16 = chunkX * 16;
        int ChunkZ16 = chunkZ * 16;

        if (world.getDimension().getType() == DimensionType.THE_NETHER ) {
            GenerateOreInNehter(world, random, ChunkX16, ChunkZ16);
            return;
        }
        if (world.getDimension().getType() == DimensionType.OVERWORLD) {
        }
        if (world.getDimension().getType() == DimensionType.THE_END) {
        }
         *//*       break;
            case 0:
                GenerateOreInOverworld(world, random, ChunkX16, ChunkZ16);
                break;
            case 1:
                GenerateOreInEnd(world, random, ChunkX16, ChunkZ16);
                break;*//*
        }

   *//* @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, ChunkGenerator chunkGenerator, AbstractChunkProvider chunkProvider)
    {
        int ChunkX16 = chunkX * 16;
        int ChunkZ16 = chunkZ * 16;

        switch (world.provider.getDimension()) {
            case -1:
                GenerateOreInNehter(world, random, ChunkX16, ChunkZ16);
                break;
            case 0:
                GenerateOreInOverworld(world, random, ChunkX16, ChunkZ16);
                break;
            case 1:
                GenerateOreInEnd(world, random, ChunkX16, ChunkZ16);
                break;
        }
    }*//*

    public void GenerateOreInEnd(World world, Random random, int X, int Z) {
    }

    public void GenerateOreInOverworld(World world, Random random, int X, int Z) {
        *//*int ChunkX = X + random.nextInt(16);
        int ChunkZ = Z + random.nextInt(16);
        if (PetRockConfig.enableWorldGen) {
            for (int i = 0; i < 16; i++) {
                BlockPos blockPos = new BlockPos(ChunkX, random.nextInt(65), ChunkZ);
                new WorldGenMinable(PRBlocks.stoneiumore.getDefaultState(), 6)
                        .generate(world, random, blockPos);
            }
        }*//*
    }

    public void GenerateOreInNehter(World world, Random random, int X, int Z)
    {
        //   addOreSpawn()
    }*/
}
