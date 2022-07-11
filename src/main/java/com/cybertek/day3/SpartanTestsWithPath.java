package com.cybertek.day3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartanTestsWithPath {

    @BeforeAll
    public static void init() {
        baseURI = "http://18.233.99.140:8000/";

    }

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON).and().pathParam("id", "10").
                when().get("api/spartans/{id}");

        assertEquals("application/json", response.contentType());
        assertEquals(200, response.getStatusCode());


        assertEquals("10", response.path("id").toString());
        assertEquals("Lorenza", response.path("name").toString());
        assertEquals("Female", response.path("gender").toString());

    }

    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON).
                when().get("api/spartans/");

        assertEquals("application/json", response.contentType());
        assertEquals(200, response.getStatusCode());

        List<String> a = response.path("name");
        System.out.println(a);

    }

}
