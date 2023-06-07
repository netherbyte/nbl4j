package com.netherbyte.nbl4j;

import static java.lang.System.exit;

public class LoggerManager {
    public static Logger getLogger(String name) {
        return new Logger() {
            @Override
            public String getLoggerName() {
                return name;
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
        };
    }
}