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

public class ClayKilnBlock extends Block {
    // The yield bonus from crushing ore first only pays off here, after the full chain completes -
    // crushing alone (Ore Crushing Stone) is 1:1 and grants no free duplication.
    private static final int INGOT_YIELD = 2;

    public ClayKilnBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getMainHandItem();
        ItemStack offhand = player.getOffhandItem();

        if (held.is(ModItems.CRUSHED_COPPER_ORE.get()) && offhand.is(Items.CHARCOAL)) {
            held.shrink(1);
            offhand.shrink(1);
            ItemStack ingot = new ItemStack(Items.COPPER_INGOT, INGOT_YIELD);
            if (!player.getInventory().add(ingot)) {
                player.drop(ingot, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
