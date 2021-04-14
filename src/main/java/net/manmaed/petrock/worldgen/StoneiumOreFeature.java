package net.manmaed.petrock.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Random;

public class StoneiumOreFeature extends OreFeature {
    public StoneiumOreFeature(Codec<OreFeatureConfig> oreFeatureConfigCodec) {
        super(oreFeatureConfigCodec);
    }

    @Override
    public boolean generate(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, OreFeatureConfig oreFeatureConfig) {
        float f = random.nextFloat() * (float) Math.PI;
        float f1 = (float) oreFeatureConfig.size / 8.0F;
        int i = MathHelper.ceil(((float) oreFeatureConfig.size / 16.0F * 2.0F + 1.0F) / 2.0F);
        double d0 = (double) blockPos.getX() + Math.sin((double) f) * (double) f1;
        double d1 = (double) blockPos.getX() - Math.sin((double) f) * (double) f1;
        double d2 = (double) blockPos.getZ() + Math.cos((double) f) * (double) f1;
        double d3 = (double) blockPos.getZ() - Math.cos((double) f) * (double) f1;
        int j = 2;
        double d4 = (double) (blockPos.getY() + random.nextInt(3) - 2);
        double d5 = (double) (blockPos.getY() + random.nextInt(3) - 2);
        int k = blockPos.getX() - MathHelper.ceil(f1) - i;
        int l = blockPos.getY() - 2 - i;
        int i1 = blockPos.getZ() - MathHelper.ceil(f1) - i;
        int j1 = 2 * (MathHelper.ceil(f1) + i);
        int k1 = 2 * (2 + i);

        for (int l1 = k; l1 <= k + j1; ++l1) {
            for (int i2 = i1; i2 <= i1 + j1; ++i2) {
                /*LogHelper.fatal(blockPos);*/
                return this.func_207803_a(seedReader, random, oreFeatureConfig, d0, d1, d2, d3, d4, d5, k, l, i1, j1, k1);
            }
        }

        return false;
    }
}
