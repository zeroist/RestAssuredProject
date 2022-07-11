package com.cybertek.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiTestsWithParameters {
    @BeforeAll
    public static void init() {

        baseURI = "http://18.233.99.140:1000/ords/hr";

    }

    @Test
    public void test1(){
        Response response = given().header("Content-Type", "application/json").queryParam("q","{\"region_id\": 2}")
                .when().log().all().get("/countries");

        response.prettyPrint();

        assertEquals(200,response.getStatusCode());
        assertEquals("application/json",response.header("content-type"));
        assertTrue(response.body().asString().contains("United States of America"));



    }


}
