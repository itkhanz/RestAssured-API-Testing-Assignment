package com.itkhanz.api;

import com.itkhanz.constants.Route;
import com.itkhanz.constants.enums.City;
import com.itkhanz.specs.StreetsSpecBuilder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class StreetsApi {
    private static final Logger logger = LogManager.getLogger(StreetsApi.class);

    @Step
    public static Response getStreetsForPostCodeAndCity(String postalCode, String city) {
        String endPoint = String.format("/%s/%s" + Route.STREETS, postalCode, city);

        logger.info("Making GET call to Streets Api with postcode {} and city {}", postalCode,city);
        return given(StreetsSpecBuilder.getRequestSpec())
                .when()
                    .get(endPoint)
                .then()
                    .spec(StreetsSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }

    @Step
    public static Response getStreetsForBerlin() {

        logger.info("Making GET call to Streets Api with postcode {} and city {}",  City.BERLIN.getPostalCode(), City.BERLIN.name().toLowerCase());
        return given(StreetsSpecBuilder.getRequestSpecForBerlin())
                .when()
                    .get("/{code}/{city}" + Route.STREETS)
                .then()
                    .spec(StreetsSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }
}
