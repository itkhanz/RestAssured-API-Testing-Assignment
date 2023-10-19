package com.itkhanz.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
POJO for nested map inside parent StreetsRoot containing city name and its list of streets
 */
@Data
@NoArgsConstructor
public class CityStreets {
    @JsonProperty("City")
    private String city;

    @JsonProperty("Streets")
    private List<String> streets;
}
