package com.nornity.dawnbound.block;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PrimitiveWorkStumpBlock extends Block {
    public PrimitiveWorkStumpBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide() || !Config.SERVER.allowAxeChoppedPlanks.get()) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getMainHandItem();
        ItemStack offhand = player.getOffhandItem();
        if (held.is(ItemTags.LOGS) && offhand.is(ItemTags.AXES)) {
            held.shrink(1);
            ItemStack planks = new ItemStack(ModItems.ROUGH_PLANKS.get(), Config.SERVER.axeChoppedPlankYield.get());
            if (!player.getInventory().add(planks)) {
                player.drop(planks, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
