package com.itkhanz.factories;

import com.itkhanz.models.pojos.Cities;
import com.itkhanz.models.pojos.StreetsRoot;
import com.itkhanz.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataLoader {

    @DataProvider(name = "citiesData")
    public static Object[][] getForCitiesForPostalCode() {
        List<Cities> citiesData = JacksonUtils.getCitiesForPostalCode();
        return citiesData.stream()
                .map(city -> new Object[]{city.getCode(), city.getCities()})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "streetsData")
    public static Object[][] getForStreetsForPostalCode() {
        List<StreetsRoot> streetsData = JacksonUtils.getStreetsForPostalCode();
        return streetsData.stream()
                .flatMap(streetsRoot -> streetsRoot.getCityStreets().stream()
                        .map(cityStreets -> new Object[]{
                                streetsRoot.getCode(),
                                cityStreets.getCity(),
                                cityStreets.getStreets()
                        }))
                .toArray(Object[][]::new);
    }
}
