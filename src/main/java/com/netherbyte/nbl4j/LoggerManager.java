package com.netherbyte.nbl4j;

import static java.lang.System.exit;

@Deprecated
public class LoggerManager {
    /**
     * Creates a new logger instance
     * @param name Name of the logger instance
     * @return Logger instance
     * @deprecated Use Loggers.get()
     * @since 1.0
     */
    @Deprecated
    public static Logger getLogger(String name) {
        return new SimpleLogger(name);
    }
}