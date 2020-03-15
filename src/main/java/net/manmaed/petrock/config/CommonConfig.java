package net.manmaed.petrock.config;

/**
 * Created by manmaed on 07/12/2019.
 * author: Naxanria
 */
public class CommonConfig {
    /*private static CommonConfig instance;
    private final ForgeConfigSpec.Builder builder;
    public ForgeConfigSpec.BooleanValue enableStoneiumGen;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        instance = this;
        this.builder = builder;

        builder.comment("PetRock Common Config");

        worldgen();
    }

    public static CommonConfig get() {
        return instance;
    }

    public void reload()
    {

    }

    private static String key(String name) {
        return Refs.id + ".config.common." + name;
    }

    private void worldgen() {
        builder.push("worldgen").comment("World Generation Options");

        enableStoneiumGen = builder
                .comment("Enables the Generation of Stoneium Ore")
                .translation(key("worldgen.enablestoneium"))
                .define("enablestoneium", true);

        builder.pop();
    }*/
}
