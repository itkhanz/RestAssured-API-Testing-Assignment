package com.itkhanz.specs;

import com.itkhanz.constants.Route;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.Matchers.isA;

/**
 * Abstracts the common request and response specifications for Cities API
 * These SpecBuilder helps to reuse same specs across multiple API calls
 * It helps to place the common configuration and validation for API calls under one place
 */
public class CitiesSpecBuilder {

  public static RequestSpecification getRequestSpec() {
    return new RequestSpecBuilder()
      .setBaseUri(Route.BASE_URI)
      .setBasePath(Route.BASE_PATH)
      .addFilter(new AllureRestAssured())
      .log(LogDetail.ALL)
      .build();
  }

  public static ResponseSpecification getResponseSpec() {
    return new ResponseSpecBuilder()
      //.expectStatusCode(200)
      .expectContentType(ContentType.JSON)
      .expectBody("Cities", isA(List.class))
      .log(LogDetail.ALL)
      .build();
  }

  public static ResponseSpecification getInvalidPostCodeResponseSpec() {
    return new ResponseSpecBuilder()
      //.expectStatusCode(404)
      .expectBody(Matchers.blankOrNullString())
      .log(LogDetail.ALL)
      .build();
  }


}
