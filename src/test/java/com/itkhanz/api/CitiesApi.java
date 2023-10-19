package com.itkhanz.api;

import com.itkhanz.constants.Globals;
import com.itkhanz.specs.CitiesSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CitiesApi {
    public static Response getCitiesForPostCode(String postalCode) {
        return given(CitiesSpecBuilder.getRequestSpec())
                .when()
                    .get("/" + postalCode)
                .then()
                    .spec(CitiesSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }

    public static Response getCitiesForInvalidPostCode() {
        return given(CitiesSpecBuilder.getRequestSpec())
                .when()
                    .get("/" + Globals.INVALID_POSTAL_CODE)
                .then()
                    .spec(CitiesSpecBuilder.getInvalidPostCodeResponseSpec())
                    .extract().response()
                ;
    }


}
