package net.darkhax.leveltextfix;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class LevelTextFixNeoForge {

    public LevelTextFixNeoForge() {
        if (FMLEnvironment.dist.isClient()) {
            new LevelTextFixCommon(FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + ".json").toFile());
        }
    }
}