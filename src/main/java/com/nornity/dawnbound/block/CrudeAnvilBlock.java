package com.nornity.dawnbound.block;

import com.nornity.dawnbound.event.GuidanceMessages;
import com.nornity.dawnbound.registry.ModItems;
import com.nornity.dawnbound.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CrudeAnvilBlock extends Block {
    private static final int REPAIR_DIVISOR = 3;
    private static final VoxelShape SHAPE = Block.box(2, 0, 3, 14, 8, 13);

    public CrudeAnvilBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(
        ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!itemStack.is(ModItemTags.ANVIL_REPAIRABLE_TOOLS) || !itemStack.isDamageableItem()) {
            if (!itemStack.isEmpty() && !level.isClientSide()) {
                GuidanceMessages.sendActionBar(player, "dawnbound.message.anvil_needs_repairable_tool");
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!itemStack.isDamaged()) {
            if (!level.isClientSide()) {
                GuidanceMessages.sendActionBar(player, "dawnbound.message.anvil_tool_not_damaged");
            }
            return InteractionResult.SUCCESS;
        }

        ItemStack offhand = player.getOffhandItem();
        if (!offhand.is(ModItems.TOOL_BINDING.get())) {
            if (!level.isClientSide()) {
                GuidanceMessages.sendActionBar(player, "dawnbound.message.anvil_needs_binding");
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        if (!level.isClientSide()) {
            int repairAmount = Math.max(1, itemStack.getMaxDamage() / REPAIR_DIVISOR);
            itemStack.setDamageValue(Math.max(0, itemStack.getDamageValue() - repairAmount));
            if (!player.hasInfiniteMaterials()) {
                offhand.shrink(1);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
