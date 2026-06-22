package com.nornity.dawnbound.registry;

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

    public static final DeferredBlock<Block> FLAT_STONE_WORK_SURFACE = BLOCKS.register(
        "flat_stone_work_surface",
        id -> new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.STONE)
            .sound(SoundType.STONE)
            .strength(1.5f, 2.0f)
            .noOcclusion())
    );

    public static final DeferredBlock<Block> PRIMITIVE_WORK_STUMP = BLOCKS.register(
        "primitive_work_stump",
        id -> new Block(BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, id))
            .mapColor(MapColor.WOOD)
            .sound(SoundType.WOOD)
            .strength(2.0f, 2.5f)
            .noOcclusion())
    );
}
