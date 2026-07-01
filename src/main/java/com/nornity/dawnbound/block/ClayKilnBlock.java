package com.nornity.dawnbound.block;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ClayKilnBlock extends Block {
    // The yield bonus from crushing ore first only pays off here, after the full chain completes -
    // crushing alone (Ore Crushing Stone) is 1:1 and grants no free duplication.
    private static final int INGOT_YIELD = 2;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public ClayKilnBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(
        ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (hand != InteractionHand.MAIN_HAND || !itemStack.is(ModItems.CRUSHED_COPPER_ORE.get())) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        ItemStack offhand = player.getOffhandItem();
        if (!offhand.is(Items.CHARCOAL)) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!level.isClientSide()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
                offhand.shrink(1);
            }
            ItemStack ingot = new ItemStack(Items.COPPER_INGOT, INGOT_YIELD);
            if (!player.getInventory().add(ingot)) {
                player.drop(ingot, false);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
