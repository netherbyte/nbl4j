package com.netherbyte.nbl4j;

public interface Logger {
    /**
     * @return Name of the logger instance
     * @since 1.0
     */
    public String getName();

    /**
     * Prints a message to the console
     * @param level Channel to print in
     * @param x The message to print
     * @since 1.2
     */
    public void log(Level level, String x);

    /**
     * Prints a message to the DEBUG channel
     * @param x The message to log
     * @since 1.0
     */
    public <T> void debug(T x);

    /**
     * Traces a message to the DEBUG channel
     * @param x The message to log
     * @since 1.2
     */
    public <T> void trace(T x);

    /**
     * Traces a message to the provided channel
     * @param x The message to log
     * @param level The channel to log in
     * @since 1.2
     */
    public <T> void trace(T x, Level level);

    /**
     * Prints a message to the INFO channel
     * @param x The message to log
     * @since 1.0
     */
    public <T> void info(T x);

    /**
     * Prints a message to the WARN channel
     * @param x The message to log
     * @since 1.0
     */
    public <T> void warn(T x);

    /**
     * Prints a message to the ERROR channel
     * @param x The message to log
     * @since 1.0
     */
    public <T> void error(T x);
}
