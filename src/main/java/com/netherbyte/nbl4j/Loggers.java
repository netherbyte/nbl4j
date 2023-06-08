package com.netherbyte.nbl4j;

public class Loggers {
    /**
     * Creates a new logger instance
     * @param name Name of the logger instance
     * @return Logger instance
     * @since 1.1
     */
    public static Logger get(String name) {
        return new SimpleLogger(name);
    }
}
