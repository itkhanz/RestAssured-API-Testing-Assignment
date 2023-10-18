package com.itkhanz.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StreetsTest {
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
                .expectBody("Streets", isA(List.class))
                .log(LogDetail.ALL)
                ;
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void test_streets_for_berlin_10409_postcode() {
        Response response = get("/10409/Berlin/streets").then().extract().response();

        // Verify that the "Streets" element in the response is a list with a length of 29
        response.then().body("Streets", hasSize(29));
    }
}
