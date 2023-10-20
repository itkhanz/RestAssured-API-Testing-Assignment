package com.itkhanz.models.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
POJO for cities.json
 */
@Data
@NoArgsConstructor
public class Cities {

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Cities")
    private List<String> cities;

}
