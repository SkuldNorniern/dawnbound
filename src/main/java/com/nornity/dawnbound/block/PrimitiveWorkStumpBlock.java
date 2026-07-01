package com.nornity.dawnbound.block;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.event.GuidanceMessages;
import com.nornity.dawnbound.registry.ModItems;
import com.nornity.dawnbound.tags.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
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

import java.util.Map;

public class PrimitiveWorkStumpBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 11, 14);
    private static final Map<Item, Item> LOG_TO_PLANKS = Map.ofEntries(
        Map.entry(Items.OAK_LOG, Items.OAK_PLANKS),
        Map.entry(Items.SPRUCE_LOG, Items.SPRUCE_PLANKS),
        Map.entry(Items.BIRCH_LOG, Items.BIRCH_PLANKS),
        Map.entry(Items.JUNGLE_LOG, Items.JUNGLE_PLANKS),
        Map.entry(Items.ACACIA_LOG, Items.ACACIA_PLANKS),
        Map.entry(Items.DARK_OAK_LOG, Items.DARK_OAK_PLANKS),
        Map.entry(Items.PALE_OAK_LOG, Items.PALE_OAK_PLANKS),
        Map.entry(Items.MANGROVE_LOG, Items.MANGROVE_PLANKS),
        Map.entry(Items.CHERRY_LOG, Items.CHERRY_PLANKS),
        Map.entry(Items.CRIMSON_STEM, Items.CRIMSON_PLANKS),
        Map.entry(Items.WARPED_STEM, Items.WARPED_PLANKS),
        Map.entry(Items.BAMBOO_BLOCK, Items.BAMBOO_PLANKS)
    );

    public PrimitiveWorkStumpBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(
        ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (hand != InteractionHand.MAIN_HAND || !itemStack.is(ItemTags.LOGS)) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        ItemStack offhand = player.getOffhandItem();
        if (Config.SERVER.enableSawLogToPlanksRecipe.get() && offhand.is(ModItemTags.SAWS)) {
            Item planksItem = LOG_TO_PLANKS.get(itemStack.getItem());
            if (planksItem != null && Config.SERVER.sawPlankYield.get() > 0) {
                if (!level.isClientSide()) {
                    processLog(itemStack, new ItemStack(planksItem, Config.SERVER.sawPlankYield.get()), player);
                    damageOffhandTool(offhand, player, Config.SERVER.sawDurabilityCostPerPlankCraft.get());
                }
                return InteractionResult.SUCCESS;
            }
        }

        if (Config.SERVER.allowAxeChoppedPlanks.get() && offhand.is(ItemTags.AXES) && Config.SERVER.axeChoppedPlankYield.get() > 0) {
            if (!level.isClientSide()) {
                processLog(itemStack, new ItemStack(ModItems.ROUGH_PLANKS.get(), Config.SERVER.axeChoppedPlankYield.get()), player);
                damageOffhandTool(offhand, player, 1);
            }
            return InteractionResult.SUCCESS;
        }

        if (!level.isClientSide()) {
            GuidanceMessages.sendActionBar(player, "dawnbound.message.stump_needs_tool");
        }
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    private static void processLog(ItemStack logStack, ItemStack output, Player player) {
        if (!player.hasInfiniteMaterials()) {
            logStack.shrink(1);
        }
        if (!player.getInventory().add(output)) {
            player.drop(output, false);
        }
    }

    private static void damageOffhandTool(ItemStack toolStack, Player player, int amount) {
        if (amount > 0 && !player.hasInfiniteMaterials()) {
            toolStack.hurtAndBreak(amount, player, EquipmentSlot.OFFHAND);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
