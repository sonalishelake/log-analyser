package com.github.sonalishelake.loganalyser.model;

public class ContextLogFile {
    private static ContextLogFile INSTANCE;

    private String logFilePath;

    private ContextLogFile() {
    }

    public static ContextLogFile getInstance() {
        if (INSTANCE == null) INSTANCE = new ContextLogFile();
        return INSTANCE;
    }

    //get and set the file path
    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

}
