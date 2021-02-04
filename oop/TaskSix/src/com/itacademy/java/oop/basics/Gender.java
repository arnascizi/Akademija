package com.itacademy.java.oop.basics;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private String genderValue;

    Gender(String genderValue) {
        this.genderValue = genderValue;
    }

    public String getGenderValue() {
        return genderValue;
    }
}
