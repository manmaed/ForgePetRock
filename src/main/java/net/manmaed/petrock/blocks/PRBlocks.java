package net.manmaed.petrock.blocks;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

/**
 * Created by manmaed on 26/11/2019.
 */
public class PRBlocks {

    @ObjectHolder(Refs.Register + "stoneiumore")
    public static Block stoneiumore;

    @ObjectHolder(Refs.Register + "stoneiumblock")
    public static Block stoneiumblock;

    public static void load() {

        stoneiumore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("stoneiumore");
        stoneiumblock = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("stoneiumblock");

        PetRock.getRegisteryHandler().registerBlock(stoneiumore);
        PetRock.getRegisteryHandler().registerBlock(stoneiumblock);

    }
}
