package com.cybertek.day4;

import com.cybertek.utilities.HRTestBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestWithPath extends HRTestBase {
    @DisplayName("get request to countries with path method")
    @Test
    public void test1() {
        Response response = given().
                header("Content-Type", "application/json").
                queryParam("q", "{\"region_id\": 2}").
                when().get("/countries");

        assertEquals(200, response.getStatusCode());

        System.out.println("response.path(\"limit\") = " + response.path("limit"));
        System.out.println("response.path(\"hasmore\") = " + response.path("hasMore"));
        System.out.println("response.path(\"items[0].country_id\") = " + response.path("items[0].country_id"));
        String path = response.path("items[1].country_name");
        System.out.println(path);
        System.out.println("response.path(\"item[2].links[0].href\") = " + response.path("items[2].links[0].href"));
        List<String> allCountries = response.path("items.country_name");
        System.out.println("allCountries = " + allCountries);


        List<Integer> allRegion = response.path("items.region_id");
        for (Integer region : allRegion) {
            System.out.println("region = " + region);
            assertEquals(2, region);
        }


    }

    @Test
    public void test2() {
        Response response = given().accept("application/json").
                and().queryParam("q", "{\"job_id\": \"IT_PROG\"}").
                when().get("/employees");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        List<String> allJobIds = response.path("items.job_id");

        for (String jobId : allJobIds) {
            System.out.println("jobId = " + jobId);
            assertEquals("IT_PROG",jobId);
        }


    }


}
