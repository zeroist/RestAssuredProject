package com.cybertek.day6;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/*
"region_id": 1,
            "region_name": "Europe",
            "links": [
                {
                    "rel": "self",
                    "href": "http://18.233.99.140:1000/ords/hr/regions/1"
                }
            ]
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)

public class Region {
    private int region_id;
    @JsonProperty("Region_name")
    private String regionName;



}
