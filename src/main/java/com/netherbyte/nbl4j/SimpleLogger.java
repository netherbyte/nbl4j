package com.netherbyte.nbl4j;

import java.util.function.IntConsumer;

import static java.lang.System.*;

public record SimpleLogger(String name) implements Logger {
    private static IntConsumer terminateMethod;
    @Override
    public String getLoggerName() {
        return name;
    }

    @Override
    public void setTerminateMethod(IntConsumer consumer) {
        terminateMethod = consumer;
    }

    @Override
    public void log(Channel channel, String x) {
        switch (channel) {
            case DEBUG -> out.println("[" + name + "/DEBUG] " + x);
            case INFO -> out.println("[" + name + "/INFO] " + x);
            case WARN -> out.println("[" + name + "/WARN] " + x);
            case ERROR -> err.println("[" + name + "/ERROR] " + x);
            case CRITICAL -> err.println("[" + name + "/CRITICAL] " + x);
        }
    }

    @Override
    public void debug(String message) {
        log(Channel.DEBUG, message);
    }

    @Override
    public void trace(String x) {
        final String cls = x.getClass().getName();
        log(Channel.DEBUG, cls + ": " + x);
    }

    @Override
    public void trace(String x, Channel channel) {
        final String cls = x.getClass().getName();
        log(channel, cls + ": " + x);
    }

    @Override
    public void info(String message) {
        log(Channel.INFO, message);
    }

    @Override
    public void warn(String message) {
        log(Channel.WARN, message);
    }

    @Override
    public void error(String message) {
        log(Channel.ERROR, message);
    }

    @Override
    public void critical(String message) {
        log(Channel.CRITICAL, message);
        exit(1);
    }

    @Override
    public void critical(String message, int code) {
        log(Channel.CRITICAL, message);
        terminateMethod.accept(code);
    }
}
