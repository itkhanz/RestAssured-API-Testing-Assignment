package com.itkhanz.tests;

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
                //.setBaseUri("https://service.verivox.de/geo/latestv2/cities")
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

    @Test
    public void test_cities_for_10409_postcode() {
        Response response = get("/10409").then().extract().response();

        //assertThat(response.statusCode(),is(equalTo(200)));
        assertThat(response.path("Cities[0]").toString(),equalTo("Berlin"));
    }

    @Test
    public void test_cities_for_77716_postcode() {
        Response response = get("/77716").then().extract().response();

        // Verify that the response code is 200 (or the appropriate code for success)
        //response.then().statusCode(200);

        // Verify that the "Cities" element in the response contains all specified cities
        response.then().body("Cities", containsInAnyOrder("Fischerbach", "Haslach", "Hofstetten"));
    }

    @Test
    public void test_cities_for_invalid_postcode() {
        ResponseSpecBuilder customResponseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectBody(Matchers.emptyString())
                .log(LogDetail.ALL);

        RestAssured.responseSpecification = customResponseSpecBuilder.build();

        // Verify the response using the custom response specification
        Response response = get("/22333").then().extract().response();

    }
}
