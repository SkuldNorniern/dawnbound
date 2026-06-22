package com.nornity.dawnbound.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final Server SERVER;
    public static final ModConfigSpec SERVER_SPEC;

    static {
        var builder = new ModConfigSpec.Builder();
        SERVER = new Server(builder);
        SERVER_SPEC = builder.build();
    }

    public static class Server {
        public final ModConfigSpec.BooleanValue disableHandLogBreaking;
        public final ModConfigSpec.BooleanValue wrongToolDamagesPlayer;
        public final ModConfigSpec.BooleanValue wrongToolDamagesTool;
        public final ModConfigSpec.BooleanValue handBreakSoftBlocksOnly;
        public final ModConfigSpec.BooleanValue requirePrimitiveCraftingSurface;

        public final ModConfigSpec.BooleanValue disableHandLogToPlanks;
        public final ModConfigSpec.BooleanValue allowAxeChoppedPlanks;
        public final ModConfigSpec.BooleanValue enableSawLogToPlanksRecipe;
        public final ModConfigSpec.IntValue sawDurabilityCostPerPlankCraft;
        public final ModConfigSpec.IntValue axeChoppedPlankYield;
        public final ModConfigSpec.IntValue sawPlankYield;

        public final ModConfigSpec.BooleanValue requireKilnForCopper;
        public final ModConfigSpec.BooleanValue requireBloomeryForIron;
        public final ModConfigSpec.BooleanValue enableCopperBronzeStage;

        public final ModConfigSpec.BooleanValue enableCaveIns;
        public final ModConfigSpec.BooleanValue enableFoodSpoilage;
        public final ModConfigSpec.BooleanValue enableTemperatureDifficulty;

        public final ModConfigSpec.BooleanValue showFirstSpawnGuide;
        public final ModConfigSpec.BooleanValue showBlockedActionHints;
        public final ModConfigSpec.BooleanValue showFirstDayAdvancements;
        public final ModConfigSpec.BooleanValue giveStarterGuide;
        public final ModConfigSpec.BooleanValue allowGuideReopenCommand;
        public final ModConfigSpec.IntValue onboardingMessageCooldownTicks;

        Server(ModConfigSpec.Builder builder) {
            builder.push("restrictions");
            disableHandLogBreaking = builder
                .comment("Bare hands cannot harvest logs")
                .define("disableHandLogBreaking", true);
            wrongToolDamagesPlayer = builder
                .define("wrongToolDamagesPlayer", false);
            wrongToolDamagesTool = builder
                .define("wrongToolDamagesTool", true);
            handBreakSoftBlocksOnly = builder
                .define("handBreakSoftBlocksOnly", true);
            requirePrimitiveCraftingSurface = builder
                .define("requirePrimitiveCraftingSurface", true);
            builder.pop();

            builder.push("woodworking");
            disableHandLogToPlanks = builder
                .comment("Vanilla hand log -> planks crafting stays disabled")
                .define("disableHandLogToPlanks", true);
            allowAxeChoppedPlanks = builder
                .define("allowAxeChoppedPlanks", true);
            enableSawLogToPlanksRecipe = builder
                .define("enableSawLogToPlanksRecipe", true);
            sawDurabilityCostPerPlankCraft = builder
                .defineInRange("sawDurabilityCostPerPlankCraft", 1, 0, 64);
            axeChoppedPlankYield = builder
                .defineInRange("axeChoppedPlankYield", 2, 0, 64);
            sawPlankYield = builder
                .defineInRange("sawPlankYield", 4, 0, 64);
            builder.pop();

            builder.push("metal");
            requireKilnForCopper = builder
                .define("requireKilnForCopper", true);
            requireBloomeryForIron = builder
                .define("requireBloomeryForIron", true);
            enableCopperBronzeStage = builder
                .define("enableCopperBronzeStage", true);
            builder.pop();

            builder.push("difficulty");
            enableCaveIns = builder
                .define("enableCaveIns", false);
            enableFoodSpoilage = builder
                .define("enableFoodSpoilage", false);
            enableTemperatureDifficulty = builder
                .define("enableTemperatureDifficulty", false);
            builder.pop();

            builder.push("onboarding");
            showFirstSpawnGuide = builder
                .define("showFirstSpawnGuide", true);
            showBlockedActionHints = builder
                .define("showBlockedActionHints", true);
            showFirstDayAdvancements = builder
                .define("showFirstDayAdvancements", true);
            giveStarterGuide = builder
                .define("giveStarterGuide", false);
            allowGuideReopenCommand = builder
                .define("allowGuideReopenCommand", true);
            onboardingMessageCooldownTicks = builder
                .defineInRange("onboardingMessageCooldownTicks", 60, 0, 72000);
            builder.pop();
        }
    }
}
