package net.manmaed.petrock.config;

import net.manmaed.petrock.libs.Refs;
import net.minecraftforge.common.ForgeConfigSpec;


/**
 * Created by manmaed on 07/12/2019.
 * author: Naxanria
 */
public class ClientConfig {
    private static ClientConfig instance;
    private final ForgeConfigSpec.Builder builder;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        instance = this;
        this.builder = builder;

        builder.comment("PetRock Client Settings");
    }

    public static ClientConfig get() {
        return instance;
    }

    private static String key(String name) {
        return Refs.id + ".config.client." + name;
    }

    public void reload()
    {

    }
}
