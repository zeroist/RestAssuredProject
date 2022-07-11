package com.cybertek.day3;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class SpartanTestsWithPath {

    @BeforeAll
    public static void init(){
        baseURI="http://18.233.99.140:8000/";

    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON).and().pathParam("id", "10").
                when().get("api/spartans/{id}");

        assertEquals("application/json",response.contentType());
        assertEquals(200,response.getStatusCode());


       assertEquals("10",response.path("id").toString());
       assertEquals("Lorenza",response.path("name").toString());
       assertEquals("Female",response.path("gender").toString());




    }

}
