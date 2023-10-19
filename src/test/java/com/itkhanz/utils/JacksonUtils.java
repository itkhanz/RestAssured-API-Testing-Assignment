package com.itkhanz.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.itkhanz.models.pojos.Cities;
import com.itkhanz.models.pojos.StreetsRoot;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonUtils {
    public static List<Cities> getCitiesForPostalCode() {
          return readJsonAndDeserializeToPojo("cities.json", Cities.class);
    }

    public static List<StreetsRoot> getStreetsForPostalCode() {
        return readJsonAndDeserializeToPojo("streets.json", StreetsRoot.class);
    }

    public static <T> List<T> readJsonAndDeserializeToPojo(String filename, Class<T> cls) {
        String testDataFilePath = System.getProperty("user.dir") + "//src//test//resources//test-data//" + filename;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(testDataFilePath);
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, cls);
            return objectMapper.readValue(file, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read data from the file: " + filename);
        }
    }

}
