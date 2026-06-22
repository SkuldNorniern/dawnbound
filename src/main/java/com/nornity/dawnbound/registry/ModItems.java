package com.nornity.dawnbound.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("dawnbound");

    public static final DeferredItem<Item> PLANT_FIBER =
        ITEMS.registerSimpleItem("plant_fiber");
    public static final DeferredItem<Item> CORDAGE =
        ITEMS.registerSimpleItem("cordage");
    public static final DeferredItem<Item> SHARP_FLINT =
        ITEMS.registerSimpleItem("sharp_flint");
    public static final DeferredItem<Item> SHARP_STONE =
        ITEMS.registerSimpleItem("sharp_stone");
    public static final DeferredItem<Item> LOOSE_STONE =
        ITEMS.registerSimpleItem("loose_stone");
    public static final DeferredItem<Item> CLAY_LUMP =
        ITEMS.registerSimpleItem("clay_lump");
    public static final DeferredItem<Item> BARK =
        ITEMS.registerSimpleItem("bark");
}
