package net.manmaed.petrock;

import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.client.render.layers.PetRockFeatureRenderer;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.hats.PRPHats;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.net.MalformedURLException;
import java.net.URL;

public class PetRockClient {

    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";
    public static final PRPHats HATS = new PRPHats();

    public static void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        /*
         * LatvianModder Improved!
         */

        new Thread(PRHats::load).start();
        new Thread(HATS::load).start();

    }

    @OnlyIn(Dist.CLIENT)
    public static void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }



}
