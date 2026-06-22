package com.nornity.dawnbound.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> REQUIRES_HATCHET =
        TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("dawnbound", "requires_hatchet"));
    public static final TagKey<Block> REQUIRES_PICKAXE =
        TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("dawnbound", "requires_pickaxe"));
}
