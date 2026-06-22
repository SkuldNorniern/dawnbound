package com.nornity.dawnbound.block;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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

public class OreCrushingStoneBlock extends Block {
    // 1:1 - crushing is a required unlock step for the Kiln/Bloomery, not a free yield bonus.
    // The yield improvement only pays off after the full crush-then-smelt chain completes.
    private static final int CRUSHED_YIELD = 1;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 11, 15);

    public OreCrushingStoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    private static Item crushedResultFor(Item ore) {
        if (ore == Items.RAW_COPPER) {
            return ModItems.CRUSHED_COPPER_ORE.get();
        }
        if (ore == Items.RAW_IRON) {
            return ModItems.CRUSHED_IRON_ORE.get();
        }
        return null;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        ItemStack held = player.getMainHandItem();
        Item crushed = crushedResultFor(held.getItem());
        if (crushed != null) {
            held.shrink(1);
            ItemStack result = new ItemStack(crushed, CRUSHED_YIELD);
            if (!player.getInventory().add(result)) {
                player.drop(result, false);
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
