package com.nornity.dawnbound.block;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BloomeryBlock extends Block {
    private static final int CHARCOAL_COST = 2;

    public BloomeryBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getMainHandItem();
        ItemStack offhand = player.getOffhandItem();

        if (held.is(ModItems.CRUSHED_IRON_ORE.get()) && offhand.is(Items.CHARCOAL) && offhand.getCount() >= CHARCOAL_COST) {
            held.shrink(1);
            offhand.shrink(CHARCOAL_COST);
            ItemStack ingot = new ItemStack(Items.IRON_INGOT);
            if (!player.getInventory().add(ingot)) {
                player.drop(ingot, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
