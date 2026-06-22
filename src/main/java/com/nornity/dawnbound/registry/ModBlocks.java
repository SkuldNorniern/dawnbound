package com.nornity.dawnbound.registry;

import com.nornity.dawnbound.block.BloomeryBlock;
import com.nornity.dawnbound.block.ClayKilnBlock;
import com.nornity.dawnbound.block.FirePitBlock;
import com.nornity.dawnbound.block.FlatStoneWorkSurfaceBlock;
import com.nornity.dawnbound.block.OreCrushingStoneBlock;
import com.nornity.dawnbound.block.PrimitiveWorkStumpBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("dawnbound");

    public static final DeferredBlock<Block> PRIMITIVE_WORK_MAT = BLOCKS.register(
        "primitive_work_mat",
        id -> new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.DIRT)
            .sound(SoundType.WOOL)
            .strength(0.5f, 0.5f)
            .noOcclusion())
    );

    public static final DeferredBlock<FlatStoneWorkSurfaceBlock> FLAT_STONE_WORK_SURFACE = BLOCKS.register(
        "flat_stone_work_surface",
        id -> new FlatStoneWorkSurfaceBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.STONE)
            .sound(SoundType.STONE)
            .strength(1.5f, 2.0f)
            .noOcclusion())
    );

    public static final DeferredBlock<PrimitiveWorkStumpBlock> PRIMITIVE_WORK_STUMP = BLOCKS.register(
        "primitive_work_stump",
        id -> new PrimitiveWorkStumpBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.WOOD)
            .sound(SoundType.WOOD)
            .strength(2.0f, 2.5f)
            .noOcclusion())
    );

    public static final DeferredBlock<FirePitBlock> FIRE_PIT = BLOCKS.register(
        "fire_pit",
        id -> new FirePitBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.STONE)
            .sound(SoundType.STONE)
            .strength(1.0f, 2.0f)
            .lightLevel(state -> 7)
            .noOcclusion())
    );

    public static final DeferredBlock<OreCrushingStoneBlock> ORE_CRUSHING_STONE = BLOCKS.register(
        "ore_crushing_stone",
        id -> new OreCrushingStoneBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.STONE)
            .sound(SoundType.STONE)
            .strength(2.0f, 3.0f)
            .noOcclusion())
    );

    public static final DeferredBlock<ClayKilnBlock> CLAY_KILN = BLOCKS.register(
        "clay_kiln",
        id -> new ClayKilnBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.TERRACOTTA_ORANGE)
            .sound(SoundType.STONE)
            .strength(2.5f, 4.0f)
            .noOcclusion())
    );

    public static final DeferredBlock<BloomeryBlock> BLOOMERY = BLOCKS.register(
        "bloomery",
        id -> new BloomeryBlock(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.STONE)
            .sound(SoundType.STONE)
            .strength(3.5f, 5.0f)
            .requiresCorrectToolForDrops())
    );
}
