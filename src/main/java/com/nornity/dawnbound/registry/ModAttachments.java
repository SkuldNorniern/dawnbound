package com.nornity.dawnbound.registry;

import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
        DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, "dawnbound");

    public static final Supplier<AttachmentType<Boolean>> HAS_SEEN_INTRO = ATTACHMENT_TYPES.register(
        "has_seen_intro",
        () -> AttachmentType.builder(() -> Boolean.FALSE).serialize(Codec.BOOL.fieldOf("value")).build()
    );
}
