package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class GuidanceMessages {
    private static final Map<UUID, Long> LAST_HINT_TICK = new HashMap<>();

    private GuidanceMessages() {
    }

    public static void sendActionBar(Player player, String translationKey) {
        if (!Config.SERVER.showBlockedActionHints.get()) {
            return;
        }

        long now = player.level().getGameTime();
        Long last = LAST_HINT_TICK.get(player.getUUID());
        if (last != null && now - last < Config.SERVER.onboardingMessageCooldownTicks.get()) {
            return;
        }

        LAST_HINT_TICK.put(player.getUUID(), now);
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable(translationKey)));
        }
    }
}
