package com.itkhanz.utils;

import com.itkhanz.constants.enums.StatusCode;
import com.itkhanz.models.pojos.Cities;
import com.itkhanz.models.pojos.CityStreets;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Utility class to store all the reusable assertions for API Tests validation
 * These assertions are called from these methods with @Step annotation
 * Methods annotated with allure @Step annotation are displayed as separate test step in allure report
 */
public class AssertionUtils {
    private static final Logger logger = LogManager.getLogger(AssertionUtils.class);

    /**
     * This method performs assertions for validation of status code
     * @param actualStatusCode
     * @param statusCode StatusCode ENUM constant that stores code and message
     */
    @Step
    public static void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    /**
     * This method validates that the cities returned in response match the expected cities
     * @param responseCities Cities Pojo created from response
     * @param expectedCities list of cities as String that are expected to be present in response
     */
    @Step
    public static void assertCitiesEqual(Cities responseCities, List<String> expectedCities) {
        assertThat(responseCities.getCities(), equalTo(expectedCities));
    }

    /**
     * This method validates that the Streets returned in response contain the expected streets (with special characters and spaces)
     * @param responseStreets CityStreets Pojo created from response
     * @param expectedStreets list of streets in a city as String that are expected to be present in response
     */
    @Step
    public static void assertStreetsResponseContain(CityStreets responseStreets, List<String> expectedStreets) {
        assertThat(expectedStreets, everyItem(in(responseStreets.getStreets())));
    }


    /**
     * This method validates the count of streets returned form calling Streets API based on city and postcode
     * @param streets List of streets returned in response body
     * @param expectedStreetsCount expected count of streets as integer
     */
    @Step
    public static void assertTotalNumberOfStreets(List<String> streets, int expectedStreetsCount) {
        assertThat(streets, hasSize(expectedStreetsCount));
    }
}
