package net.darkhax.leveltextfix;

import java.io.File;

public class LevelTextFixCommon {

    public static Config config;

    public LevelTextFixCommon(File file) {

        config = Config.load(file);
    }
}
