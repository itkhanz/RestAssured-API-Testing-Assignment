package com.itkhanz.tests;

import com.itkhanz.api.CitiesApi;
import com.itkhanz.factories.TestDataLoader;
import com.itkhanz.models.pojos.Cities;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CitiesTest {
    private static final Logger logger = LogManager.getLogger(StreetsTest.class);

    @Test(dataProvider = "citiesData", dataProviderClass = TestDataLoader.class)
    public void test_cities_for_given_postcode(String code, List<String> cities) {
        Response response = CitiesApi.getCitiesForPostCode(code);

        logger.info("Performing Assertions for Cities returned for code {}", code);

        //Approach 01: Parse response using JsonPath
        //assertThat(response.jsonPath().getList("Cities"), is(cities));

        //Approach 02: Deserialize response using POJO Classes
        Cities responseCities = response.as(Cities.class);
        assertThat(responseCities.getCities(), is(cities));
    }


    @Test
    public void test_cities_for_invalid_postcode() {
        // Verify the response using the custom response specification
        Response response = CitiesApi.getCitiesForInvalidPostCode();

        //No need to perform assertions as these are automatically validated using ResponseSpec
    }
}
