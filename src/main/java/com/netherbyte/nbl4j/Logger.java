package com.netherbyte.nbl4j;

public interface Logger {
    public String getLoggerName();
    public void debug(String message);
    public void info(String message);
    public void warn(String message);
    public void error(String message);
    public void critical(String message);
}
