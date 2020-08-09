package net.manmaed.petrock.libs;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.blocks.PRBlocks;
import net.manmaed.petrock.entitys.EntityPetRock;
import net.manmaed.petrock.entitys.PREntityTypes;
import net.manmaed.petrock.entitys.PREntitys;
import net.manmaed.petrock.items.PRItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by manmaed on 24/03/2020
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    /*@SubscribeEvent
    public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        *//*PREntitys.load();*//*
        event.getRegistry().register(PREntityTypes.PETROCK.get());
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(PREntityTypes.PETROCK.get(), EntityPetRock.setCustomAttributes().func_233813_a_());
        });
        //event.getRegistry().register(EntityType.Builder.create(EntityPetRock:: new, EntityClassification.MISC).size(0.5f, 0.5f).build("petrock").setRegistryName("petrock"));
    }*/

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