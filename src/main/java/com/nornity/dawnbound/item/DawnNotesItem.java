package com.nornity.dawnbound.item;

import com.nornity.dawnbound.event.OnboardingEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class DawnNotesItem extends Item {
    public DawnNotesItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            OnboardingEvents.sendIntro(player);
        }
        return InteractionResult.SUCCESS;
    }
}
