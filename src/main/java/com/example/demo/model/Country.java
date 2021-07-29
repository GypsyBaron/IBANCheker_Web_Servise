package com.example.demo.model;

public class Country {
    private final String countryCode;
    private final Integer ibanLength;

    public Country(String countryCode, Integer ibanLength) {
        this.countryCode = countryCode;
        this.ibanLength = ibanLength;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Integer getIbanLength() {
        return ibanLength;
    }
}
