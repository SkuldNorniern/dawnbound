package com.nornity.dawnbound.tool;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class PrimitiveToolMaterials {
    public static final TagKey<Item> PRIMITIVE_TOOL_MATERIALS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "primitive_tool_materials"));

    public static final ToolMaterial PRIMITIVE =
        new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 30, 1.6F, 0.0F, 1, PRIMITIVE_TOOL_MATERIALS);
}
