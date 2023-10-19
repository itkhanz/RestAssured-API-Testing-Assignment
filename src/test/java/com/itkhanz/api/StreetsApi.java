package com.itkhanz.api;

import com.itkhanz.specs.CitiesSpecBuilder;
import com.itkhanz.specs.StreetsSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StreetsApi {
    public static Response getStreetsForPostCodeAndCity(String postalCode, String city) {
        String endPoint = String.format("/%s/%s/streets", postalCode, city);

        return given(StreetsSpecBuilder.getRequestSpec())
                .when()
                    .get(endPoint)
                .then()
                    .spec(StreetsSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }

    public static Response getStreetsForBerlin() {
        return given(StreetsSpecBuilder.getRequestSpecForBerlin())
                .when()
                    .get("/{code}/{city}/streets")
                .then()
                    .spec(StreetsSpecBuilder.getResponseSpec())
                    .extract().response()
                ;
    }
}
