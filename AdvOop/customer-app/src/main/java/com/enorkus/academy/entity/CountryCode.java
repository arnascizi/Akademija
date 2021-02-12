package com.enorkus.academy.entity;

public enum CountryCode {

    LT("Lithuania"),
    LV("Latvia"),
    EE("Estonia"),
    SE("Sweden");

    private final String countryCodeValue;

    CountryCode(String countryCodeValue) {
        this.countryCodeValue = countryCodeValue;
    }

    public String getCountryCodeValue() {
        return countryCodeValue;
    }
}
