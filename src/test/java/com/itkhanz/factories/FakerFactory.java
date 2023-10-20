package com.itkhanz.factories;

import com.github.javafaker.Faker;

public class FakerFactory {
    private static Faker faker;
    private static FakerFactory fakerFactory;

    private FakerFactory() {
        faker = new Faker();
    }

    public static FakerFactory getInstance() {
        if(fakerFactory ==null) {
            fakerFactory = new FakerFactory();
        }
        return fakerFactory;
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() { return faker.name().lastName(); }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getStreet() {
        return faker.address().streetAddress();
    }

    public String getCity() {
        return faker.address().cityName();
    }

    public String getPostCode() {
        return faker.address().zipCode();
    }

    public String getCountry() {
        return faker.address().country();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }
}
