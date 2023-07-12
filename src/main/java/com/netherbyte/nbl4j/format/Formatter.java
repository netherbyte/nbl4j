package com.netherbyte.nbl4j.format;

import com.netherbyte.nbl4j.Config;
import com.netherbyte.nbl4j.Level;
import com.netherbyte.nbl4j.Logger;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;

public class Formatter {
    public static String getFormatConfig(Logger logger) {
        return Config.getConfig().getString("format");
    }

    public static JSONObject getColorConfig(Logger logger) {
        return Config.getConfig().getJSONObject("colors");
    }

    public static String replaceAll(Logger logger, String message, Level level) {
        String replacement = getFormatConfig(logger);

        // replace time
        Date currentDate = Date.from(Instant.now());
        replacement = replacement.replaceAll("%HH", String.valueOf(currentDate.getHours()));
        replacement = replacement.replaceAll("%mm", String.valueOf(currentDate.getMinutes()));
        replacement = replacement.replaceAll("%ss", String.valueOf(currentDate.getSeconds()));

        // replace thread
        replacement = replacement.replaceAll("%t", Thread.currentThread().getName());

        // replace level
        replacement = replacement.replaceAll("%level", String.valueOf(level));

        // replace logger name
        replacement = replacement.replaceAll("%logger", logger.getName());

        // replace message
        replacement = replacement.replaceAll("%message", message);

        // colors
        switch (level) {
            case DEBUG: replacement = AnsiCodes.find(getColorConfig(logger).getString("DEBUG"));
        }

        return replacement;
    }
}
