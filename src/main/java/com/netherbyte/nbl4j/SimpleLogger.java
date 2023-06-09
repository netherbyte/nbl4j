package com.netherbyte.nbl4j;

import java.util.Arrays;
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
    public <T> void debug(T x) {
        log(Channel.DEBUG, String.valueOf(x));
    }

    @Override
    public <T> void trace(T x) {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        log(Channel.DEBUG, "Begin stack trace");
        for (int i = 2; i < stes.length; i++)
            log(Channel.DEBUG, String.valueOf(stes[i]));
        log(Channel.DEBUG, String.valueOf(x));
    }

    @Override
    public <T> void trace(T x, Channel channel) {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        log(channel, "Begin stack trace");
        for (int i = 2; i < stes.length; i++)
            log(channel, String.valueOf(stes[i]));
        log(channel, String.valueOf(x));
    }

    @Override
    public <T> void info(T x) {
        log(Channel.INFO, String.valueOf(x));
    }

    @Override
    public <T> void warn(T x) {
        log(Channel.WARN, String.valueOf(x));
    }

    @Override
    public <T> void error(T x) {
        log(Channel.ERROR, String.valueOf(x));
    }

    @Override
    public <T> void critical(T x) {
        log(Channel.CRITICAL, String.valueOf(x));
        exit(1);
    }

    @Override
    public <T> void critical(T x, int code) {
        log(Channel.CRITICAL, String.valueOf(x));
        terminateMethod.accept(code);
    }
}
