package net.manmaed.petrock;

import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.client.render.layers.PetRockFeatureRenderer;
import net.manmaed.petrock.command.PRCommands;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.hats.PRPHats;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.Refs;
import net.manmaed.petrock.libs.RegisterHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(Refs.id)
public class PetRock {

    /*
    TODO: PetRock Hat
    1. Make it sick to head
    2. Only On Some peoples head (Req. Network Stuff)
    3. Get List of uuids that the hat should be on (Like how petorcks do event hats)
     */

    /*
    TODO: World Gen
    1. Add World Gen
    2. ablity to disable worldgen via config ( See Configs to do )
     */

    /*
    TODO: Configs
    1. Add Config for worldgen
     */

    private static RegisterHandler registeryHandler;
    public static String slow_uuid = "d2839efc727a426397ce3c73cdee5013";
    private static PRItems items;
    public static final ItemGroup itemGroup = new ItemGroup(Refs.id) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(PRItems.petrockbox);
        }
    };

    public PetRock() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        registeryHandler = new RegisterHandler();
        PREntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());


        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, this::doPlayerStuff);
        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static RegisterHandler getRegisteryHandler() {
        return registeryHandler;
    }

    private void init(final FMLCommonSetupEvent event) {
        // some preinit code;
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PREntityTypes.PETROCK.get(), EntityPetRock.setCustomAttributes().build());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        /*PRPHats.addhattoplayer("2eebcb1af63e4a80b380801a10f88d4e");*/
        //[17:17:25.191] [Render thread/INFO] [libs.LogHelper/]: [INFO]:-:[PetRock]: PlayerUUID: 2eebcb1af63e4a80b380801a10f88d4e - null
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        /*
         * LatvianModder Improved!
         */
        new Thread(PRHats::load).start();
        /*new Thread(PRPHats::load).start();*/

    }

    private void doPlayerStuff(RenderPlayerEvent event) {
        event.getRenderer().addLayer(new PetRockFeatureRenderer(event.getRenderer()));
    }

    private void serverLoad(FMLServerStartingEvent event) {
        PRCommands.register(event.getServer().getCommandManager().getDispatcher());
    }
}
