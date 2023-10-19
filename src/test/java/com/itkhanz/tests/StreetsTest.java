package com.itkhanz.tests;

import com.itkhanz.api.StreetsApi;
import com.itkhanz.factories.TestDataLoader;
import com.itkhanz.models.pojos.CityStreets;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StreetsTest {

    @Test(dataProvider = "streetsData", dataProviderClass = TestDataLoader.class)
    public void test_streets_for_given_city_and_postcode(String code, String city, List<String> streets) {
        Response response = StreetsApi.getStreetsForPostCodeAndCity(code, city);

        CityStreets citiesStreets = response.as(CityStreets.class);

        assertThat(streets, everyItem(in(citiesStreets.getStreets())));
    }


    @Test
    public void test_streets_for_berlin_10409_postcode() {
        Response response = StreetsApi.getStreetsForBerlin();

        // Verify that the "Streets" element in the response is a list with a length of 29
        response.then().body("Streets", hasSize(29));
    }
}
