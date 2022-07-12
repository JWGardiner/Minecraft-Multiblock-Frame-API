package com.jwg.frameapi;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class exampleBlocks {
    public static final Block TEST_FRAME = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block TEST_FILLER = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final controllerBlock TEST_CONTROLLER = new controllerBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("tmp", "frame"), TEST_FRAME);
        Registry.register(Registry.ITEM, new Identifier("tmp", "frame"), new BlockItem(TEST_FRAME, new Item.Settings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("tmp", "filler"), TEST_FILLER);
        Registry.register(Registry.ITEM, new Identifier("tmp", "filler"), new BlockItem(TEST_FILLER, new Item.Settings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("tmp", "controller"), TEST_CONTROLLER);
        Registry.register(Registry.ITEM, new Identifier("tmp", "controller"), new BlockItem(TEST_CONTROLLER, new Item.Settings().group(ItemGroup.MISC)));

    }
}