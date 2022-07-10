package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DocumentType;

public class HrGetRequests {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://18.233.99.140:1000/ords/hr";

    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1() {
        Response response = RestAssured.get("/regions");

        System.out.println("response.statusCode() = " + response.statusCode());
    }


    @Test
    public void test3(){
        Response response = RestAssured.given().accept(ContentType.JSON).when().get("/regions/2");
        Assertions.assertEquals(response.getStatusCode(),200);
        Assertions.assertEquals(response.contentType(),"aplication/json");
        Assertions.assertTrue(response.body().asString().contains("Americas"));

    }


}
