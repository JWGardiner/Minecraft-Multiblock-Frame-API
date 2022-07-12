package com.jwg.frameapi;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class frameapi implements ModInitializer {
	//More or less, everything in this file is not useful, and here for debugging purposes.
	//In a real-world scenario, all that'd be in here is logging, and initializing everything.
	//To test the API is working there may be blocks, items etc all in here; just remember:
	//This is an API; it adds nothing on it's own and requires other mods to do anything.
	public static final Logger LOGGER = LoggerFactory.getLogger("Frame-API");

	public static final Block TEST_FRAME = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static final Block TEST_FILLER = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));
	public static final controllerBlock TEXT_CONTROLLER = new controllerBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("JWG's Multiblock Frame API has started initializing!");

		Registry.register(Registry.BLOCK, new Identifier("tmp", "frame"), TEST_FRAME);
		Registry.register(Registry.ITEM, new Identifier("tmp", "frame"), new BlockItem(TEST_FRAME, new Item.Settings().group(ItemGroup.MISC)));

		Registry.register(Registry.BLOCK, new Identifier("tmp", "filler"), TEST_FILLER);
		Registry.register(Registry.ITEM, new Identifier("tmp", "filler"), new BlockItem(TEST_FILLER, new Item.Settings().group(ItemGroup.MISC)));

		Registry.register(Registry.BLOCK, new Identifier("tmp", "controller"), TEXT_CONTROLLER);
		Registry.register(Registry.ITEM, new Identifier("tmp", "controller"), new BlockItem(TEXT_CONTROLLER, new Item.Settings().group(ItemGroup.MISC)));
	}
}
