package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.tags.ModBlockTags;
import net.minecraft.tags.ItemTags;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class HandRestrictionEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (!Config.SERVER.disableHandLogBreaking.get()) {
            return;
        }
        if (!event.getState().is(ModBlockTags.REQUIRES_HATCHET)) {
            return;
        }
        if (!event.getEntity().getMainHandItem().is(ItemTags.AXES)) {
            event.setNewSpeed(0.0f);
        }
    }
}
