package com.netherbyte.nbl4j;

import java.util.function.IntConsumer;

import static java.lang.System.exit;

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
    public void debug(String message) {
        System.out.println("[" + name + "/DEBUG] " + message);
    }

    @Override
    public void info(String message) {
        System.out.println("[" + name + "/INFO] " + message);
    }

    @Override
    public void warn(String message) {
        System.out.println("[" + name + "/WARN] " + message);
    }

    @Override
    public void error(String message) {
        System.err.println("[" + name + "/ERROR] " + message);
    }

    @Override
    public void critical(String message) {
        System.err.println("[" + name + "/CRITICAL] " + message);
        exit(1);
    }

    @Override
    public void critical(String message, int code) {
        System.err.println("[" + name + "/CRITICAL] " + message);
        terminateMethod.accept(code);
    }
}
