package net.darkhax.leveltextfix.common.impl;

import net.darkhax.pricklemc.common.api.config.ConfigManager;
import org.apache.commons.lang3.StringUtils;

public class LevelTextFixMod {

    public static final String MOD_ID = "leveltextfix";
    public static final String MOD_NAME = "LevelTextFix";
    public static Config config;

    public static void init() {
        config = ConfigManager.load(MOD_ID, new Config());
    }

    public static boolean isNumeric(final CharSequence cs) {
        if (StringUtils.isEmpty(cs)) {
            return false;
        }
        final int sz = cs.length();
        final int start = cs.charAt(0) == '-' || cs.charAt(0) == '+' ? 1 : 0;
        for (int i = start; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}