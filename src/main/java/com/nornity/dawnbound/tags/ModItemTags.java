package com.nornity.dawnbound.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PRIMITIVE_FIBERS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "primitive_fibers"));
    public static final TagKey<Item> SHARP_STONES =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "sharp_stones"));
    public static final TagKey<Item> PRIMITIVE_TOOL_HEADS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "primitive_tool_heads"));
    public static final TagKey<Item> SAWS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "saws"));
}
