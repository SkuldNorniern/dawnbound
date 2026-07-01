package com.nornity.dawnbound.event;

import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class ItemTooltipEvents {
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        String key = tooltipKey(item);
        if (key != null) {
            event.getToolTip().add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
        }
    }

    private static String tooltipKey(Item item) {
        if (item == ModItems.PLANT_FIBER.get()) {
            return "item.dawnbound.plant_fiber.tooltip";
        }
        if (item == ModItems.CORDAGE.get()) {
            return "item.dawnbound.cordage.tooltip";
        }
        if (item == ModItems.SHARP_FLINT.get()) {
            return "item.dawnbound.sharp_flint.tooltip";
        }
        if (item == ModItems.SHARP_STONE.get()) {
            return "item.dawnbound.sharp_stone.tooltip";
        }
        if (item == ModItems.LOOSE_STONE.get()) {
            return "item.dawnbound.loose_stone.tooltip";
        }
        if (item == ModItems.CLAY_LUMP.get()) {
            return "item.dawnbound.clay_lump.tooltip";
        }
        if (item == ModItems.BARK.get()) {
            return "item.dawnbound.bark.tooltip";
        }
        if (item == ModItems.ROUGH_PLANKS.get()) {
            return "item.dawnbound.rough_planks.tooltip";
        }
        if (item == ModItems.STONE_HATCHET.get()) {
            return "item.dawnbound.stone_hatchet.tooltip";
        }
        if (item == ModItems.DIGGING_STICK.get()) {
            return "item.dawnbound.digging_stick.tooltip";
        }
        if (item == ModItems.KNAPPED_STONE_HEAD.get()) {
            return "item.dawnbound.knapped_stone_head.tooltip";
        }
        if (item == ModItems.BOUND_STONE_HEAD.get()) {
            return "item.dawnbound.bound_stone_head.tooltip";
        }
        if (item == ModItems.RESIN.get()) {
            return "item.dawnbound.resin.tooltip";
        }
        if (item == ModItems.RAWHIDE_CORD.get()) {
            return "item.dawnbound.rawhide_cord.tooltip";
        }
        if (item == ModItems.CRUDE_HANDLE.get()) {
            return "item.dawnbound.crude_handle.tooltip";
        }
        if (item == ModItems.TOOL_BINDING.get()) {
            return "item.dawnbound.tool_binding.tooltip";
        }
        if (item == ModItems.SAW.get()) {
            return "item.dawnbound.saw.tooltip";
        }
        if (item == ModItems.BOUND_SAW.get()) {
            return "item.dawnbound.bound_saw.tooltip";
        }
        if (item == ModItems.CRUSHED_COPPER_ORE.get()) {
            return "item.dawnbound.crushed_copper_ore.tooltip";
        }
        if (item == ModItems.CRUSHED_IRON_ORE.get()) {
            return "item.dawnbound.crushed_iron_ore.tooltip";
        }
        if (item == ModItems.DAWN_NOTES.get()) {
            return "item.dawnbound.dawn_notes.tooltip";
        }
        if (item == ModItems.PRIMITIVE_WORK_MAT.get()) {
            return "block.dawnbound.primitive_work_mat.tooltip";
        }
        if (item == ModItems.FLAT_STONE_WORK_SURFACE.get()) {
            return "block.dawnbound.flat_stone_work_surface.tooltip";
        }
        if (item == ModItems.PRIMITIVE_WORK_STUMP.get()) {
            return "block.dawnbound.primitive_work_stump.tooltip";
        }
        if (item == ModItems.FIRE_PIT.get()) {
            return "block.dawnbound.fire_pit.tooltip";
        }
        if (item == ModItems.ORE_CRUSHING_STONE.get()) {
            return "block.dawnbound.ore_crushing_stone.tooltip";
        }
        if (item == ModItems.CRUDE_ANVIL.get()) {
            return "block.dawnbound.crude_anvil.tooltip";
        }
        if (item == ModItems.CLAY_KILN.get()) {
            return "block.dawnbound.clay_kiln.tooltip";
        }
        if (item == ModItems.BLOOMERY.get()) {
            return "block.dawnbound.bloomery.tooltip";
        }
        if (item == ModItems.PIT_KILN.get()) {
            return "block.dawnbound.pit_kiln.tooltip";
        }
        return null;
    }
}
