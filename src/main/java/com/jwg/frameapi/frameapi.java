package com.jwg.frameapi;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class frameapi implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Frame-API");

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("JWG's Multiblock Frame API has started initializing!");
	}
}
