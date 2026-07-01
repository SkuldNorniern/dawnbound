package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.tags.ModBlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class HandRestrictionEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();

        if (Config.SERVER.disableHandLogBreaking.get()
            && event.getState().is(ModBlockTags.REQUIRES_HATCHET)
            && !player.getMainHandItem().is(ItemTags.AXES)) {
            event.setNewSpeed(0.0f);
            GuidanceMessages.sendActionBar(player, "dawnbound.message.logs_need_hatchet");
            return;
        }
        if (event.getState().is(ModBlockTags.REQUIRES_PICKAXE)
            && !player.getMainHandItem().is(ItemTags.PICKAXES)) {
            event.setNewSpeed(0.0f);
            GuidanceMessages.sendActionBar(player, "dawnbound.message.requires_pickaxe");
        }
    }
}
