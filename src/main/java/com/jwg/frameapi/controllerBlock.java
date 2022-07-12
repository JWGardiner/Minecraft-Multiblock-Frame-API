package com.jwg.frameapi;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.jwg.frameapi.exampleBlocks.TEST_CONTROLLER;
import static com.jwg.frameapi.exampleBlocks.TEST_FRAME;
import static com.jwg.frameapi.frame.isOpen;
import static net.minecraft.block.RedstoneTorchBlock.*;

public class controllerBlock extends Block {
    Block controllerBlock;
    public static BooleanProperty doorOpen;
    public controllerBlock(AbstractBlock.Settings settings) {
            super(settings);
            this.setDefaultState((BlockState) this.getDefaultState().with(doorOpen, false));
        }
        @Nullable
        public BlockState getPlacementState(ItemPlacementContext ctx) {
            return (BlockState) this.getDefaultState().with(doorOpen, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
        }
        public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
                boolean bl = (Boolean) state.get(doorOpen);
                if (bl != world.isReceivingRedstonePower(pos)) {
                    if (bl) {
                        world.scheduleBlockTick(pos, this, 0);
                    } else {
                        world.setBlockState(pos, (BlockState) state.cycle(doorOpen), 2);
                    }
                }
                isOpen(world.isReceivingRedstonePower(pos), true, TEST_CONTROLLER, TEST_FRAME, pos, world);
            }
        public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
            if ((Boolean) state.get(doorOpen) && !world.isReceivingRedstonePower(pos)) {
                world.setBlockState(pos, (BlockState) state.cycle(doorOpen), 2);
            }
        }
        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(doorOpen);
        }

        static {
            doorOpen = LIT;
        }
    }
