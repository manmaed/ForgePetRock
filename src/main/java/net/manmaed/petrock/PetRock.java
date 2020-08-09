package net.manmaed.petrock;

import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.command.PRCommands;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.Refs;
import net.manmaed.petrock.libs.RegisterHandler;
import net.manmaed.petrock.worldgen.WorldGen;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
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
        PRConfig.register(ModLoadingContext.get());
        PREntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static RegisterHandler getRegisteryHandler() {
        return registeryHandler;
    }

    private void init(final FMLCommonSetupEvent event) {
        // some preinit code;
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PREntityTypes.PETROCK.get(), EntityPetRock.setCustomAttributes().func_233813_a_());
        });
        WorldGen.setupOreGen();
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        RenderingRegistry.registerEntityRenderingHandler(PREntityTypes.PETROCK.get(), RenderPetRock::new);
        /*
         * LatvianModder Improved!
         */
        new Thread(PRHats::load).start();
    }

    private void serverLoad(FMLServerStartingEvent event) {
        PRCommands.register(event.getServer().getCommandManager().getDispatcher());
    }
}
