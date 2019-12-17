package net.manmaed.petrock;

import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.client.render.entity.RenderPetRock;
import net.manmaed.petrock.command.PRCommands;
import net.manmaed.petrock.config.PRConfig;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.hats.PRHats;
import net.manmaed.petrock.items.PRItems;
import net.manmaed.petrock.libs.Refs;
import net.manmaed.petrock.worldgen.OreGen;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(Refs.id)
public class PetRock {

    private static RegisteryHandler registeryHandler;
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
        registeryHandler = new RegisteryHandler();
        /*config = new PRConfig();*/
        PRConfig.register(ModLoadingContext.get());

        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static RegisteryHandler getRegisteryHandler() {
        return registeryHandler;
    }

    private void init(final FMLCommonSetupEvent event) {
        // some preinit code;
        OreGen.setupOreGen();
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        if(Minecraft.getInstance().getSession().getPlayerID().replace("-","").equals(slow_uuid)){
            PRHats.slowisplaying();
        }
        RenderingRegistry.registerEntityRenderingHandler(EntityPetRock.class, RenderPetRock::new);
        /*
         * LatvianModder Improved!
         */
        new Thread(PRHats::load).start();
    }

    private void serverLoad(FMLServerStartingEvent event) {
        PRCommands.register(event.getCommandDispatcher());
    }


    public static class RegisteryHandler {
        private final ArrayList<Block> blocks = new ArrayList<>();
        private final ArrayList<Item> items = new ArrayList<>();
        public ArrayList<Block> getRegisteredBlocks()

        {
            return blocks;
        }
        public void registerBlock(Block block)
        {
            blocks.add(block);
        }
        public ArrayList<Item> getRegisteredItems()
        {
            return items;
        }
        public void registerItem(Item item)
        {
            this.items.add(item);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(EntityType.Builder.create(EntityPetRock:: new, EntityClassification.MISC).size(0.5f, 0.5f).build("petrock").setRegistryName("petrock"));
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            PRBlocks.load();
            for (Block block : PetRock.getRegisteryHandler().getRegisteredBlocks()) {
                event.getRegistry().registerAll(block);
            }
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            PRItems.load();
            for (Block block : PetRock.getRegisteryHandler().getRegisteredBlocks()) {
                /*event.getRegistry().register(new BlockItem(new Block.Properties.from(block).setRegistryName(block.getRegistryName())));*/
                event.getRegistry().register(new BlockItem(block, new Item.Properties().group(PetRock.itemGroup)).setRegistryName(block.getRegistryName()));
            }
            for (Item item : PetRock.getRegisteryHandler().getRegisteredItems()) {
                event.getRegistry().register(item);
            }
        }
    }
}
