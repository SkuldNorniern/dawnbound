package com.nornity.dawnbound.registry;

import com.nornity.dawnbound.tool.PrimitiveToolMaterials;
import net.minecraft.world.item.BlockItem;
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
    public static final DeferredItem<Item> ROUGH_PLANKS =
        ITEMS.registerSimpleItem("rough_planks");

    public static final DeferredItem<Item> FLINT_KNIFE =
        ITEMS.registerSimpleItem("flint_knife", props -> props.durability(60));
    public static final DeferredItem<Item> STONE_HATCHET =
        ITEMS.registerItem("stone_hatchet", Item::new,
            props -> props.axe(PrimitiveToolMaterials.PRIMITIVE, 5.0F, -3.2F));
    public static final DeferredItem<Item> DIGGING_STICK =
        ITEMS.registerItem("digging_stick", Item::new,
            props -> props.shovel(PrimitiveToolMaterials.PRIMITIVE, 1.5F, -3.0F));

    public static final DeferredItem<BlockItem> PRIMITIVE_WORK_MAT =
        ITEMS.registerSimpleBlockItem(ModBlocks.PRIMITIVE_WORK_MAT);
    public static final DeferredItem<BlockItem> FLAT_STONE_WORK_SURFACE =
        ITEMS.registerSimpleBlockItem(ModBlocks.FLAT_STONE_WORK_SURFACE);
    public static final DeferredItem<BlockItem> PRIMITIVE_WORK_STUMP =
        ITEMS.registerSimpleBlockItem(ModBlocks.PRIMITIVE_WORK_STUMP);
}
