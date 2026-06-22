package com.nornity.dawnbound;

import com.mojang.logging.LogUtils;
import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(Dawnbound.MODID)
public class Dawnbound {
    public static final String MODID = "dawnbound";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB =
        CREATIVE_MODE_TABS.register("dawnbound_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.dawnbound"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.SHARP_FLINT.get().getDefaultInstance())
            .displayItems((params, output) -> {
                output.accept(ModItems.PLANT_FIBER.get());
                output.accept(ModItems.CORDAGE.get());
                output.accept(ModItems.SHARP_FLINT.get());
                output.accept(ModItems.SHARP_STONE.get());
                output.accept(ModItems.LOOSE_STONE.get());
                output.accept(ModItems.CLAY_LUMP.get());
                output.accept(ModItems.BARK.get());
            })
            .build());

    public Dawnbound(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC);
    }
}
