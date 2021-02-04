package com.itacademy.java.oop.basics.task2;

public enum Bike {

    MOUNTAIN("Mountain"), ROAD("Road");

    private String displayValue;

    public String getDisplayValue() {
        return displayValue;
    }

    Bike(String displayValue) {
        this.displayValue = displayValue;
    }
}
