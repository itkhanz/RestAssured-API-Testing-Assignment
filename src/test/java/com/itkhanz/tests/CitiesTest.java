package com.itkhanz.tests;

import com.itkhanz.api.CitiesApi;
import com.itkhanz.constants.enums.StatusCode;
import com.itkhanz.factories.TestDataLoader;
import com.itkhanz.models.pojos.Cities;
import com.itkhanz.utils.AssertionUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

public class CitiesTest {
  private static final Logger logger = LogManager.getLogger(StreetsTest.class);

  @Story("Fetch Cities from Postcode")
  @Description("GET cities for a given postcode, validate 200 Status Code, and return type as list of cities")
  @Test(dataProvider = "citiesData", dataProviderClass = TestDataLoader.class)
  public void test_cities_for_given_postcode(String code, List<String> cities) {
    Response response = CitiesApi.getCitiesForPostCode(code);

    logger.info("Performing Assertions for Cities returned for code {}", code);

    //Approach 01: Parse response using JsonPath
    //assertThat(response.jsonPath().getList("Cities"), is(cities));

    //Approach 02: Deserialize response using POJO Classes
    Cities responseCities = response.as(Cities.class);

    AssertionUtils.assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    AssertionUtils.assertCitiesEqual(responseCities, cities);

    //Validation of response to be always list is done in responeSpecBuilder
  }


  @Story("Fetch Cities from Postcode")
  @Description("GET cities for a invalid postcode, validate 404 Status Code, and empty response body")
  @Test
  public void test_cities_for_invalid_postcode() {
    // Verify the response using the custom response specification
    Response response = CitiesApi.getCitiesForInvalidPostCode();

    AssertionUtils.assertStatusCode(response.statusCode(), StatusCode.CODE_404);

    //Empty Response Body is pre-verified in ResponseSpecBuilder
  }
}
