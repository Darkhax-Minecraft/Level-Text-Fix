package net.darkhax.leveltextfix;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class LevelTextFixFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        new LevelTextFixCommon(FabricLoader.getInstance().getConfigDir().resolve(Constants.MOD_ID + ".json").toFile());
    }
}