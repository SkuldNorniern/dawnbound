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
        if (item == ModItems.STONE_HATCHET.get()) {
            return "item.dawnbound.stone_hatchet.tooltip";
        }
        if (item == ModItems.DIGGING_STICK.get()) {
            return "item.dawnbound.digging_stick.tooltip";
        }
        if (item == ModItems.SAW.get()) {
            return "item.dawnbound.saw.tooltip";
        }
        if (item == ModItems.BOUND_SAW.get()) {
            return "item.dawnbound.bound_saw.tooltip";
        }
        return null;
    }
}
