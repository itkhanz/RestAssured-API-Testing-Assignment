package com.itkhanz.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itkhanz.models.pojos.Cities;
import com.itkhanz.models.pojos.StreetsRoot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonUtils {

    public static List<Cities> getForCitiesForPostalCode() {
        ObjectMapper objectMapper = new ObjectMapper();
        String citiesDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//cities.json";
        try {
            return objectMapper.readValue(
                    new File(citiesDataFilePath),
                    new TypeReference<List<Cities>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read cities.json from test-data resources directory");
        }
    }

    public static List<StreetsRoot> getForStreetsForPostalCode() {
        ObjectMapper objectMapper = new ObjectMapper();
        String streetsDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//streets.json";
        try {
            return objectMapper.readValue(
                    new File(streetsDataFilePath),
                    new TypeReference<List<StreetsRoot>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read streets.json from test-data resources directory");
        }
    }

}
