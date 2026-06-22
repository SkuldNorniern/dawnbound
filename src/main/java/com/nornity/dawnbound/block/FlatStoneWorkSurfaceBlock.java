package com.nornity.dawnbound.block;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FlatStoneWorkSurfaceBlock extends Block {
    public FlatStoneWorkSurfaceBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        ItemStack held = player.getMainHandItem();
        if (held.is(ModItems.SHARP_STONE.get()) || held.is(ModItems.LOOSE_STONE.get())) {
            held.shrink(1);
            ItemStack knapped = new ItemStack(ModItems.KNAPPED_STONE_HEAD.get());
            if (!player.getInventory().add(knapped)) {
                player.drop(knapped, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
