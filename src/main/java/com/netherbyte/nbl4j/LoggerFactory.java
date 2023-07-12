package com.netherbyte.nbl4j;

import com.netherbyte.nbl4j.format.Formatter;

import java.util.Arrays;

public class LoggerFactory {
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
    public static Logger getLogger(String name) {
        return new Logger() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public void log(Level level, String x) {
                System.out.println(Formatter.replaceAll(this, x, level));
            }

            @Override
            public <T> void debug(T x) {
                log(Level.DEBUG, String.valueOf(x));
            }

            @Override
            public <T> void trace(T x) {
                //log(Level.INFO, String.valueOf(x));
            }

            @Override
            public <T> void trace(T x, Level level) {
                //log(level, String.valueOf(x));
            }

            @Override
            public <T> void info(T x) {
                log(Level.INFO, String.valueOf(x));
            }

            @Override
            public <T> void warn(T x) {
                log(Level.WARN, String.valueOf(x));
            }

            @Override
            public <T> void error(T x) {
                log(Level.ERROR, String.valueOf(x));
            }
        };
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
}
