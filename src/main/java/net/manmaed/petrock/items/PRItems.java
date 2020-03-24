package net.manmaed.petrock.items;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.libs.Refs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;

/**
 * Created by manmaed on 25/11/2019.
 */
public class PRItems {

    @ObjectHolder(Refs.Register + "orderform")
    public static Item orderform;

    @ObjectHolder(Refs.Register + "petrock_spawn_egg")
    public static Item petrockspawnegg;

    @ObjectHolder(Refs.Register + "petrockbox")
    public static Item petrockbox;

    @ObjectHolder(Refs.Register + "stoneium")
    public static Item stoneium;

    @ObjectHolder(Refs.Register + "kibble")
    public static Item kibble;


    public static void load() {

        orderform = new OrderForm(new Item.Properties().group(PetRock.itemGroup).maxStackSize(1), "orderform");
        petrockbox = new PetRockBox(new Item.Properties().group(PetRock.itemGroup), "petrockbox");
        stoneium = new Stoneium(new Item.Properties().group(PetRock.itemGroup), "stoneium");
        kibble = new Kibble(new Item.Properties().group(PetRock.itemGroup), "kibble");
        petrockspawnegg = new PetRockSpawnEgg(new Item.Properties().group(ItemGroup.MISC), "petrock_spawn_egg",0xdcd5d5, 0x686565);


        /*orderform.setRegistryName("orderform");
        //petrockspawn.setRegistryName("petrockspawn");
        stoneium.setRegistryName("stoneium");
        kibble.setRegistryName("kibble");*/

        //registerItem(orderform);

        PetRock.getRegisteryHandler().registerItem(orderform);
        PetRock.getRegisteryHandler().registerItem(petrockbox);
        PetRock.getRegisteryHandler().registerItem(stoneium);
        PetRock.getRegisteryHandler().registerItem(kibble);
        PetRock.getRegisteryHandler().registerItem(petrockspawnegg);
    }
}
