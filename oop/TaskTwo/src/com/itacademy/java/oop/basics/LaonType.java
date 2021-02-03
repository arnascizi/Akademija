package com.itacademy.java.oop.basics;

public enum LaonType {
    LEASING("Leasing"), CONSUMER("Consumer");

    private final String displayLoan;

    LaonType(String displayLoan) {
        this.displayLoan = displayLoan;
    }

    public String getDisplayLoan() {
        return displayLoan;
    }
}
