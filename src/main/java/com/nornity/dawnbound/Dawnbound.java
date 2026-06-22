package com.nornity.dawnbound;

import com.mojang.logging.LogUtils;
import com.nornity.dawnbound.config.Config;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(Dawnbound.MODID)
public class Dawnbound {
    public static final String MODID = "dawnbound";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Dawnbound(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC);
    }
}
