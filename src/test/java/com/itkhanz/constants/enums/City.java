package com.itkhanz.constants.enums;

public enum City {
    BERLIN("10409"),
    FISCHERBACH("77716"),
    HASLACH("77716"),
    HOFSTETTEN("77716");

    private String postalCode;

    City(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
