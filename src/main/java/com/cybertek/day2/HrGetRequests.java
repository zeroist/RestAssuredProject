package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HrGetRequests {

    @BeforeAll
    public static void init() {
        baseURI = "http://18.233.99.140:1000/ords/hr";

    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1() {
        Response response = get("/regions");

        System.out.println("response.statusCode() = " + response.statusCode());
    }

    @Test
    public void test3() {
        Response response =given().accept(ContentType.JSON).when().get("/regions/2");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.contentType(), "application/json");
        assertTrue(response.body().asString().contains("Americas"));

    }


}
