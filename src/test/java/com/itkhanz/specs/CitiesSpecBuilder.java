package com.itkhanz.specs;

import com.itkhanz.constants.Globals;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.Matchers.isA;

public class CitiesSpecBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Globals.BASE_URI)
                .log(LogDetail.ALL)
                .build()
                ;
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectBody("Cities", isA(List.class))
                .log(LogDetail.ALL)
                .build()
                ;
    }

    public static ResponseSpecification getInvalidPostCodeResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectBody(Matchers.blankOrNullString())
                .log(LogDetail.ALL)
                .build()
                ;
    }


}
