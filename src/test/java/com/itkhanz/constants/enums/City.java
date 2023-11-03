package com.itkhanz.constants.enums;

/**
 * Stores city name, and post codes that are used in the tests as parameters
 */
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
