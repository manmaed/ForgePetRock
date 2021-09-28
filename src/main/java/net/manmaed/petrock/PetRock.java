package net.manmaed.petrock;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.command.PRCommands;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.LogHelper;
import net.manmaed.petrock.libs.Refs;
import net.manmaed.petrock.libs.RegisterHandler;
import net.manmaed.petrock.worldgen.WorldGenHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
    1. Only On Some peoples head (Req. Network Stuff)
    2. Get List of uuids that the hat should be on (Like how petorcks do event hats)
     */

    /*
    TODO: World Gen
    1. Find Out What World gen is doing LOL
     */

    private static RegisterHandler registeryHandler;
    private static boolean ishatsloaded = false;
    public static final ItemGroup itemGroup = new ItemGroup(Refs.id) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(PRItems.petrockbox);
        }
    };

    public static boolean getHatsLoaded() {
        return ishatsloaded;
    }
    public static void setHatsLoaded() {
        ishatsloaded = true;
    }

    public PetRock() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PRBlocks.FEATURES.register(event);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PetRockClient::doClientStuff);
        registeryHandler = new RegisterHandler();

        PREntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        /*DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PetRockClient::doPlayerStuff);
        });*/
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, PRConfig.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, PRConfig.CLIENT_CONFIG);
        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, WorldGenHandler::addStuffToBiomes);
    }

    public static RegisterHandler getRegisteryHandler() {
        return registeryHandler;
    }

    private void init(final FMLCommonSetupEvent event) {
        // some preinit code;
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PREntityTypes.PETROCK.get(), EntityPetRock.setCustomAttributes().create());
        });
        event.enqueueWork(WorldGenHandler::registerConfiguredFeatures);
    }


    private void serverLoad(FMLServerStartingEvent event) {
        PRCommands.register(event.getServer().getCommandManager().getDispatcher());
    }
}
