package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.registry.ModAttachments;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class OnboardingEvents {
    private static final String[] INTRO_LINES = {
        "dawnbound.onboarding.intro.1",
        "dawnbound.onboarding.intro.2",
        "dawnbound.onboarding.intro.3",
        "dawnbound.onboarding.intro.4"
    };

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!Config.SERVER.showFirstSpawnGuide.get()) {
            return;
        }

        Player player = event.getEntity();
        if (player.getData(ModAttachments.HAS_SEEN_INTRO.get())) {
            return;
        }
        player.setData(ModAttachments.HAS_SEEN_INTRO.get(), true);

        for (String key : INTRO_LINES) {
            player.sendSystemMessage(Component.translatable(key));
        }
    }
}
