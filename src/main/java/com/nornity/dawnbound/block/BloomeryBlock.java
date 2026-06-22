package com.nornity.dawnbound.block;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.BlockPos;
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

public class BloomeryBlock extends Block {
    // Iron needs more heat than copper, so it costs more charcoal per craft - a real cost,
    // not a duplication exploit, since crushing itself (Ore Crushing Stone) is 1:1.
    private static final int CHARCOAL_COST = 2;
    private static final int INGOT_YIELD = 2;
    private static final VoxelShape SHAPE = Block.box(1, 0, 1, 15, 16, 15);

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
            ItemStack ingot = new ItemStack(Items.IRON_INGOT, INGOT_YIELD);
            if (!player.getInventory().add(ingot)) {
                player.drop(ingot, false);
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
