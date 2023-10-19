package com.itkhanz.tests;

import com.itkhanz.constants.Globals;
import com.itkhanz.factories.TestDataLoader;
import com.itkhanz.models.pojos.Cities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CitiesTest {

    @BeforeClass
    public void setup() {
        // Set up the base URL and any other configurations
        RestAssured.baseURI = "https://service.verivox.de/geo/latestv2/cities";

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("Cities", isA(List.class))
                .log(LogDetail.ALL)
                ;
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test(dataProvider = "citiesData", dataProviderClass = TestDataLoader.class)
    public void test_cities_for_given_postcode(String code, List<String> cities) {


        Response response = get("/" + code);

        //Approach 01: Parse response using JsonPath
        //assertThat(response.jsonPath().getList("Cities"), is(cities));

        //Approach 02: Deserialize response using POJO Classes
        Cities responseCities = response.as(Cities.class);
        assertThat(responseCities.getCities(), is(cities));
    }


    @Test
    public void test_cities_for_invalid_postcode() {
        ResponseSpecBuilder customResponseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectBody(Matchers.blankOrNullString())
                .log(LogDetail.ALL);

        RestAssured.responseSpecification = customResponseSpecBuilder.build();

        // Verify the response using the custom response specification
        Response response = get("/" + Globals.INVALID_POSTAL_CODE);

        //No need to perform assertions as these are automatically validated using ResponseSpec
    }
}
