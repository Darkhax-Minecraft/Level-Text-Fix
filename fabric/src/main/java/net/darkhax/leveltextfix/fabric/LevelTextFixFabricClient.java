package net.darkhax.leveltextfix.fabric;

import net.darkhax.leveltextfix.common.impl.LevelTextFixMod;
import net.fabricmc.api.ClientModInitializer;

public class LevelTextFixFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        LevelTextFixMod.init();
    }
}