package com.tutorial;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("tutorial-mod");

    public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).strength(0.5f));


    public static final Item DAVID = Registry.register(Registry.ITEM, new Identifier("tutorial", "david"),
            new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(
                    new FoodComponent.Builder().hunger(400).saturationModifier(0.6f).build())));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings()));

        LOGGER.info("Hello Fabric world!");
        LOGGER.info("Block has been registered!");
    }
}