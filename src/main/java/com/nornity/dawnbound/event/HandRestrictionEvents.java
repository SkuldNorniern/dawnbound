package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.tags.ModBlockTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HandRestrictionEvents {
    private static final Map<UUID, Long> lastHintTick = new HashMap<>();

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();

        if (Config.SERVER.disableHandLogBreaking.get()
            && event.getState().is(ModBlockTags.REQUIRES_HATCHET)
            && !player.getMainHandItem().is(ItemTags.AXES)) {
            event.setNewSpeed(0.0f);
            sendHint(player, "dawnbound.message.requires_hatchet");
            return;
        }
        if (event.getState().is(ModBlockTags.REQUIRES_PICKAXE)
            && !player.getMainHandItem().is(ItemTags.PICKAXES)) {
            event.setNewSpeed(0.0f);
            sendHint(player, "dawnbound.message.requires_pickaxe");
        }
    }

    private static void sendHint(Player player, String translationKey) {
        if (!Config.SERVER.showBlockedActionHints.get()) {
            return;
        }
        long now = player.level().getGameTime();
        Long last = lastHintTick.get(player.getUUID());
        if (last != null && now - last < Config.SERVER.onboardingMessageCooldownTicks.get()) {
            return;
        }
        lastHintTick.put(player.getUUID(), now);
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable(translationKey)));
        }
    }
}
