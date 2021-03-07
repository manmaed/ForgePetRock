package net.manmaed.petrock.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PRConfig {
    private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static final String CATEGORY_WORLDGEN = "worldgen";

    public static ForgeConfigSpec.BooleanValue ENABLE_WORLD_GEN;
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_VAIN_SIZE;
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_CHANCE;
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_YMIN;
    public static ForgeConfigSpec.IntValue STONEIUM_ORE_YMAX;


    static {
        COMMON_BUILDER.comment("WorldGen Settings").push(CATEGORY_WORLDGEN);
        setupWorldGenConfig();
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void setupWorldGenConfig(){
        ENABLE_WORLD_GEN = COMMON_BUILDER.comment("World Gen? [DEFAULT: true]")
                .define("worldgen_enabled", true);
        STONEIUM_ORE_CHANCE = COMMON_BUILDER.comment("The chance for Stoneium Ore to generate underground, 1 in X chunks. Bigger number means more rare [DEFAULT: 5]")
                .defineInRange("stoneium_ore_chance", 5, 1, 1000);
        STONEIUM_ORE_VAIN_SIZE = COMMON_BUILDER.comment("Size of a Vain [DEFAULT: 10]")
                .defineInRange("stoneium_ore_vain_size", 10, 1, 50);
        /*STONEIUM_ORE_YMIN = COMMON_BUILDER.comment("The minimum Y level that Stoneium can spawn underground [DEFAULT: 40] [Not Used]")
                .defineInRange("stoneium_ore_ymin", 40, 0, 255);*/
        STONEIUM_ORE_YMAX = COMMON_BUILDER.comment("The maximum Y level that Stoneium can spawn underground [DEFAULT: 80]")
                .defineInRange("stoneium_ore_ymax", 80, 0, 255);
    }
}
