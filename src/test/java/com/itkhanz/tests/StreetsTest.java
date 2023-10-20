package com.itkhanz.tests;

import com.itkhanz.api.StreetsApi;
import com.itkhanz.factories.TestDataLoader;
import com.itkhanz.models.pojos.CityStreets;
import com.itkhanz.utils.AssertionUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

public class StreetsTest {
    private static final Logger logger = LogManager.getLogger(StreetsTest.class);

    @Story("Fetch Streets from Postcode and City")
    @Description("GET streets for given postcode and city, validate 200 Status Code, and return type as list of streets with special characters")
    @Test(dataProvider = "streetsData", dataProviderClass = TestDataLoader.class)
    public void test_streets_for_given_city_and_postcode(String code, String city, List<String> streets) {

        Response response = StreetsApi.getStreetsForPostCodeAndCity(code, city);

        CityStreets responseCitiesStreets = response.as(CityStreets.class);

        logger.info("Validating that all  the streets exist in returned response for code {} and city {}", code, city);
        AssertionUtils.assertStreetsResponseContain(responseCitiesStreets, streets);

        //Validation of response to be always list is done in responeSpecBuilder
    }


    @Story("Fetch Streets from Postcode and City")
    @Description("GET streets for Berlin 10409, validate 200 Status Code, and total streets to be 29")
    @Test
    public void test_streets_for_berlin_10409_postcode() {
        Response response = StreetsApi.getStreetsForBerlin();

        logger.info("Validating that the Cities Api returns 29 streets for Berlin 10409");
        // Verify that the "Streets" element in the response is a list with a length of 29

        //Approach 01
        //response.then().body("Streets", hasSize(29));

        //Approach 02
        // Extract the "Streets" using JsonPath
        JsonPath jsonPath = response.jsonPath();
        List<String> streets = jsonPath.getList("Streets");
        AssertionUtils.assertTotalNumberOfStreets(streets, 29);
    }
}
