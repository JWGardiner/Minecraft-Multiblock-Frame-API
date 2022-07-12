package com.jwg.frameapi;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class frame {
    public static void isOpen(Boolean isOpen, Boolean hasFrame, Block controller, Block frame, BlockPos pos, World world) {
        frameapi.LOGGER.info(isOpen+String.valueOf(controller)+frame+pos);
        long x = pos.getX();
        long y = pos.getY();
        long z = pos.getZ();
        boolean done = false;
        BlockState frameState = frame.getDefaultState();


    }
}