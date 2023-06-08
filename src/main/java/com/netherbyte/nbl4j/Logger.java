package com.netherbyte.nbl4j;

import java.util.function.IntConsumer;

public interface Logger {
    /**
     * @return Name of the logger instance
     * @since 1.0
     */
    public String getLoggerName();

    /**
     * Sets the method to run when the program needs to terminate
     * @param consumer
     * @since 1.1
     */
    public void setTerminateMethod(IntConsumer consumer);

    /**
     * Prints a message to the console
     * @param channel Channel to print in
     * @param x The message to print
     * @since 1.2
     */
    public void log(Channel channel, String x);

    /**
     * Prints a message to the DEBUG channel
     * @param x The message to log
     * @since 1.0
     */
    public void debug(String x);

    /**
     * Traces a message to the DEBUG channel
     * @param x The message to log
     * @since 1.2
     */
    public void trace(String x);

    /**
     * Traces a message to the provided channel
     * @param x The message to log
     * @param channel The channel to log in
     * @since 1.2
     */
    public void trace(String x, Channel channel);

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

    /**
     * Prints a message to the CRITICAL channel and stops the program
     * @param x The message to log
     * @param code The program exit code
     * @since 1.1
     */
    public void critical(String x, int code);
}
