package com.github.sonalishelake.loganalyser.model;

import java.util.Arrays;

public enum EventTypeInfo {
    APPLICATION_LOG("APPLICATION_LOG");

    private final String value;

    EventTypeInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventTypeInfo fromValue(String text) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(text))
                .findFirst()
                .orElse(null);
    }
}
