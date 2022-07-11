package com.cybertek.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartansTestWithParameters {

    @BeforeAll
    public static void init() {
        baseURI = "http://18.233.99.140:8000";

    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON).and().pathParam("id",5).when().get("/api/spartans/{id}");

        assertEquals(200,response.getStatusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Blythe"));
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON).and().pathParam("id", 500).when().
                get("/api/spartans/{id}");

        assertEquals(404,response.getStatusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("Not Found"));



    }

}
