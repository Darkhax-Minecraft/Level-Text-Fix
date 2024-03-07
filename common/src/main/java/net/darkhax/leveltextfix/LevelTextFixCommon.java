package net.darkhax.leveltextfix;

import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class LevelTextFixCommon {

    public static Config config;

    public LevelTextFixCommon(File file) {

        config = Config.load(file);
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
