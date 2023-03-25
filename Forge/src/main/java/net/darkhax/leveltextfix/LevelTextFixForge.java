package net.darkhax.leveltextfix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Constants.MOD_ID)
public class LevelTextFixForge {

    public LevelTextFixForge() {
        if (FMLEnvironment.dist.isClient()) {
            new LevelTextFixCommon(FMLPaths.CONFIGDIR.get().resolve(Constants.MOD_ID + ".json").toFile());
        }
    }
}