package com.nornity.dawnbound.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> SAWS =
        TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("dawnbound", "saws"));
}
