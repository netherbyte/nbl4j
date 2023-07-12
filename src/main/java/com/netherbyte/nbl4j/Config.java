package com.netherbyte.nbl4j;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    public static JSONObject getConfig() {
        String content = "{}";
        try {
            String path = Config.class.getClassLoader().getResource("logger.json").getPath().substring(1);
            content = Files.readString(Path.of(path));
        } catch (IOException e) {
            System.err.println("NBL4J: logger.json configuration file not found");
        }
        return new JSONObject(content);
    }
}
