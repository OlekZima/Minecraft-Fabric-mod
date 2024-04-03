package com.tutorial;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FoodItem extends Item {
    public FoodItem(Settings settings) {
        super(settings.group(ItemGroup.FOOD).fireproof().maxCount(2137));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.damage(DamageSource.STARVE, Float.MAX_VALUE);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
