package com.github.sonalishelake.loganalyser.model;

import java.util.Arrays;

public enum StateInfo {
    //constant of state
    STARTED("STARTED"),
    FINISHED("FINISHED");

    private final String value;

    StateInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StateInfo fromValue(String text) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(text))
                .findFirst()
                .orElse(null);
    }
}
