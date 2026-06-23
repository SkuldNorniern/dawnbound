package com.nornity.dawnbound;

import com.mojang.logging.LogUtils;
import com.nornity.dawnbound.config.Config;
import com.nornity.dawnbound.event.HandRestrictionEvents;
import com.nornity.dawnbound.event.OnboardingEvents;
import com.nornity.dawnbound.registry.ModAttachments;
import com.nornity.dawnbound.registry.ModBlocks;
import com.nornity.dawnbound.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
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
                output.accept(ModItems.ROUGH_PLANKS.get());
                output.accept(ModItems.FLINT_KNIFE.get());
                output.accept(ModItems.STONE_HATCHET.get());
                output.accept(ModItems.DIGGING_STICK.get());
                output.accept(ModItems.PRIMITIVE_WORK_MAT.get());
                output.accept(ModItems.FLAT_STONE_WORK_SURFACE.get());
                output.accept(ModItems.PRIMITIVE_WORK_STUMP.get());
                output.accept(ModItems.KNAPPED_STONE_HEAD.get());
                output.accept(ModItems.BOUND_STONE_HEAD.get());
                output.accept(ModItems.RESIN.get());
                output.accept(ModItems.RAWHIDE_CORD.get());
                output.accept(ModItems.CRUDE_HANDLE.get());
                output.accept(ModItems.TOOL_BINDING.get());
                output.accept(ModItems.SAW.get());
                output.accept(ModItems.BOUND_SAW.get());
                output.accept(ModItems.FIRE_PIT.get());
                output.accept(ModItems.CRUSHED_COPPER_ORE.get());
                output.accept(ModItems.CRUSHED_IRON_ORE.get());
                output.accept(ModItems.ORE_CRUSHING_STONE.get());
                output.accept(ModItems.CLAY_KILN.get());
                output.accept(ModItems.BLOOMERY.get());
                output.accept(ModItems.PIT_KILN.get());
            })
            .build());

    public Dawnbound(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModAttachments.ATTACHMENT_TYPES.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC);
        NeoForge.EVENT_BUS.register(HandRestrictionEvents.class);
        NeoForge.EVENT_BUS.register(OnboardingEvents.class);
    }
}
