package com.itacademy.java.oop.basics;

public enum Contract {
    FULL_TIME("Full-Time"), PART_TIME("Part-Time");

    private final String displayName;

    Contract(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
