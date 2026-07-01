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
    public static final TagKey<Item> KNAPPED_TOOL_HEADS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "knapped_tool_heads"));
    public static final TagKey<Item> BOUND_TOOL_HEADS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "bound_tool_heads"));
    public static final TagKey<Item> RAWHIDE_MATERIALS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "rawhide_materials"));
    public static final TagKey<Item> RESIN_BINDERS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "resin_binders"));
    public static final TagKey<Item> CRUDE_HANDLES =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "crude_handles"));
    public static final TagKey<Item> TOOL_BINDINGS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "tool_bindings"));
    public static final TagKey<Item> ANVIL_REPAIRABLE_TOOLS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "anvil_repairable_tools"));
    public static final TagKey<Item> SAWS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "saws"));
}
