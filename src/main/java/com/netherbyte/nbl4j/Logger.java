package com.netherbyte.nbl4j;

public interface Logger {
    /**
     * @return Name of the logger instance
     * @since 1.0
     */
    public String getLoggerName();

    /**
     * Prints a message to the DEBUG channel
     * @param x The message to log
     * @since 1.0
     */
    public void debug(String x);

    /**
     * Prints a message to the INFO channel
     * @param x The message to log
     * @since 1.0
     */
    public void info(String x);

    /**
     * Prints a message to the WARN channel
     * @param x The message to log
     * @since 1.0
     */
    public void warn(String x);

    /**
     * Prints a message to the ERROR channel
     * @param x The message to log
     * @since 1.0
     */
    public void error(String x);

    /**
     * Prints a message to the CRITICAL channel and stops the program
     * @param x The message to log
     * @since 1.0
     */
    public void critical(String x);
}
