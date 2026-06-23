package com.nornity.dawnbound.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
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

public class PitKilnBlock extends Block {
    // A dug earthen pit burns more efficiently than an open Fire Pit: 2 logs in, 3 charcoal out.
    private static final int LOG_COST = 2;
    private static final int CHARCOAL_YIELD = 3;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 4, 15);

    public PitKilnBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getMainHandItem();
        if (held.is(ItemTags.LOGS) && held.getCount() >= LOG_COST) {
            held.shrink(LOG_COST);
            ItemStack charcoal = new ItemStack(Items.CHARCOAL, CHARCOAL_YIELD);
            if (!player.getInventory().add(charcoal)) {
                player.drop(charcoal, false);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
