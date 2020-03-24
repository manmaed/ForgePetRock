package net.manmaed.petrock.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Created by manmaed on 25/11/2019.
 */
public class OrderForm extends Item {
    public OrderForm(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if(!world.isRemote) {
            ItemStack itemStack = player.getHeldItem(hand);
            itemStack.shrink(1);
            player.inventory.addItemStackToInventory(new ItemStack(PRItems.petrockbox));
        }
        return super.onItemRightClick(world, player, hand);
    }
}
