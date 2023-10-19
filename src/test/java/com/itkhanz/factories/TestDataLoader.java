package com.itkhanz.factories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itkhanz.models.pojos.Cities;
import com.itkhanz.models.pojos.StreetsRoot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataLoader {

    @DataProvider(name = "citiesData")
    public static Object[][] getForCitiesForPostalCode() {
        ObjectMapper objectMapper = new ObjectMapper();
        String citiesDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//cities.json";
        try {
            List<Cities> citiesData = objectMapper.readValue(
                    new File(citiesDataFilePath),
                    new TypeReference<List<Cities>>() {});

            return citiesData.stream()
                    .map(city -> new Object[]{city.getCode(), city.getCities()})
                    .toArray(Object[][]::new);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read cities.json from test-data resources directory");
        }
    }

    @DataProvider(name = "streetsData")
    public static Object[][] getForStreetsForPostalCode() {
        ObjectMapper objectMapper = new ObjectMapper();
        String streetsDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//streets.json";
        try {
            List<StreetsRoot> streetsData = objectMapper.readValue(
                    new File(streetsDataFilePath),
                    new TypeReference<List<StreetsRoot>>() {});

            return streetsData.stream()
                    .flatMap(streetsRoot -> streetsRoot.getCityStreets().stream()
                            .map(cityStreets -> new Object[]{
                                    streetsRoot.getCode(),
                                    cityStreets.getCity(),
                                    cityStreets.getStreets()
                            }))
                    .toArray(Object[][]::new);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read cities.json from test-data resources directory");
        }
    }
}
