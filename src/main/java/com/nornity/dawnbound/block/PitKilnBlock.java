package com.nornity.dawnbound.block;

import com.nornity.dawnbound.event.GuidanceMessages;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
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

public class PitKilnBlock extends Block {
    // A dug earthen pit burns more efficiently than an open Fire Pit: 2 logs in, 3 charcoal out.
    private static final int LOG_COST = 2;
    private static final int CHARCOAL_YIELD = 3;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 4, 15);

    public PitKilnBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(
        ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!itemStack.is(ItemTags.LOGS)) {
            if (!itemStack.isEmpty() && !level.isClientSide()) {
                GuidanceMessages.sendActionBar(player, "dawnbound.message.pit_kiln_needs_logs");
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!player.hasInfiniteMaterials() && itemStack.getCount() < LOG_COST) {
            if (!level.isClientSide()) {
                GuidanceMessages.sendActionBar(player, "dawnbound.message.pit_kiln_needs_two_logs");
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!level.isClientSide()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(LOG_COST);
            }
            ItemStack charcoal = new ItemStack(Items.CHARCOAL, CHARCOAL_YIELD);
            if (!player.getInventory().add(charcoal)) {
                player.drop(charcoal, false);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
