package com.nornity.dawnbound.event;

import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.registry.ModAttachments;
import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
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

        if (Config.SERVER.giveStarterGuide.get()) {
            ItemStack notes = new ItemStack(ModItems.DAWN_NOTES.get());
            if (!player.getInventory().add(notes)) {
                player.drop(notes, false);
            }
        }

        sendIntro(player);
    }

    public static void sendIntro(Player player) {
        for (String key : INTRO_LINES) {
            player.sendSystemMessage(Component.translatable(key));
        }
    }

    @SubscribeEvent
    public static void onItemPickup(ItemEntityPickupEvent.Post event) {
        ItemStack stack = event.getOriginalStack();
        Item item = stack.getItem();

        if (item == ModItems.PLANT_FIBER.get()) {
            GuidanceMessages.sendActionBar(event.getPlayer(), "dawnbound.message.fiber_hint");
        } else if (item == ModItems.SHARP_FLINT.get() || item == ModItems.SHARP_STONE.get()) {
            GuidanceMessages.sendActionBar(event.getPlayer(), "dawnbound.message.sharp_edge_hint");
        } else if (item == ModItems.CORDAGE.get()) {
            GuidanceMessages.sendActionBar(event.getPlayer(), "dawnbound.message.cordage_hint");
        }
    }
}
