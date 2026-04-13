package net.darkhax.leveltextfix.impl;

import net.darkhax.leveltextfix.common.impl.LevelTextFixMod;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(LevelTextFixMod.MOD_ID)
public class NeoForgeMod {

    public NeoForgeMod() {
        if (FMLEnvironment.getDist().isClient()) {
            LevelTextFixMod.init();
        }
    }
}