//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.jwg.frameapi;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class controllerBlock extends Block {
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
            if (!world.isClient) {
                boolean bl = (Boolean) state.get(doorOpen);
                if (bl != world.isReceivingRedstonePower(pos)) {
                    if (bl) {
                        world.scheduleBlockTick(pos, this, 4);
                    } else {
                        world.setBlockState(pos, (BlockState) state.cycle(doorOpen), 2);
                    }
                }

            }
        }

        public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, RandomGenerator random) {
            if ((Boolean) state.get(doorOpen) && !world.isReceivingRedstonePower(pos)) {
                world.setBlockState(pos, (BlockState) state.cycle(doorOpen), 2);

            }
            frame.isOpen((Boolean) state.get(doorOpen));
        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(doorOpen);
        }

        static {
            doorOpen = RedstoneTorchBlock.LIT;
        }
    }
