package com.netherbyte.nbl4j;

import static com.netherbyte.nbl4j.Channel.INFO;

public class Loggers {
    /**
     * The default logging level to use if the logging level is not specified during the creation of a logger instance
     */
    //public static final Channel DEFAULT_LOGGING_LEVEL = INFO;

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
