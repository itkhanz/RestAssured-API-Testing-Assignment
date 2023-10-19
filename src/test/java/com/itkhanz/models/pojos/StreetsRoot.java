package com.itkhanz.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
POJO for streets.json
 */
@Data
@NoArgsConstructor
public class StreetsRoot {
    @JsonProperty("Code")
    private String code;

    @JsonProperty("Cities")
    private List<CityStreets> cityStreets;
}
