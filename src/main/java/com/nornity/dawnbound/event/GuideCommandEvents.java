package com.nornity.dawnbound.event;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.nornity.dawnbound.config.Config;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class GuideCommandEvents {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("dawnbound")
            .then(Commands.literal("guide")
                .executes(context -> showGuide(context.getSource()))));
    }

    private static int showGuide(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        if (!Config.SERVER.allowGuideReopenCommand.get()) {
            player.sendSystemMessage(Component.translatable("dawnbound.command.guide.disabled"));
            return 0;
        }

        OnboardingEvents.sendIntro(player);
        return Command.SINGLE_SUCCESS;
    }
}
