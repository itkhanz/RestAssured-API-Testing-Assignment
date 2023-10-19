package com.itkhanz.specs;

import com.itkhanz.constants.City;
import com.itkhanz.constants.Route;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static org.hamcrest.Matchers.isA;

public class StreetsSpecBuilder {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Route.BASE_URI)
                .setBasePath(Route.BASE_PATH)
                .log(LogDetail.ALL)
                .build()
                ;
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("Streets", isA(List.class))
                .log(LogDetail.ALL)
                .build()
                ;
    }

    public static RequestSpecification getRequestSpecForBerlin() {
        return new RequestSpecBuilder()
                .setBaseUri(Route.BASE_URI)
                .setBasePath(Route.BASE_PATH)
                .addPathParam("code", City.BERLIN.getPostalCode())
                .addPathParam("city", City.BERLIN.name().toLowerCase())
                .log(LogDetail.ALL)
                .build()
                ;
    }
}
