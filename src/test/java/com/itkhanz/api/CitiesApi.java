package com.itkhanz.api;

import com.itkhanz.constants.Globals;
import com.itkhanz.specs.CitiesSpecBuilder;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

/**
 * Stores the APIs calls for Getting the City based on Postcode
 */
public class CitiesApi {
    private static final Logger logger = LogManager.getLogger(CitiesApi.class);
    @Step
    public static Response getCitiesForPostCode(String postalCode) {
        logger.info("Making GET call to Cities Api with postcode {}", postalCode);

        return given(CitiesSpecBuilder.getRequestSpec())
                .when()
                    .get("/" + postalCode)
                .then()
                    .spec(CitiesSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }

    @Step
    public static Response getCitiesForInvalidPostCode() {
        logger.info("Making GET call to Cities Api with postcode {}", Globals.INVALID_POSTAL_CODE);

        return given(CitiesSpecBuilder.getRequestSpec())
                .when()
                    .get("/" + Globals.INVALID_POSTAL_CODE)
                .then()
                    .spec(CitiesSpecBuilder.getInvalidPostCodeResponseSpec())
                    .extract().response()
                ;
    }

}
