package net.manmaed.petrock;

import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.client.render.layers.PetRockFeatureRenderer;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";

    public static void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        /*
         * LatvianModder Improved!
         */
        if (ModList.get().isLoaded("hats")) {
           PetRock.setHatsLoaded();
        }
        new Thread(PRHats::load).start();
        /*new Thread(PRPHats::load).start();*/

    }

    @OnlyIn(Dist.CLIENT)
    public static void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }
}
