package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartansGetRequests {


    String baseUrl = "http://18.233.99.140:8000";

    @Test
    public void test1() {

        Response response = RestAssured.given().accept(ContentType.JSON).when().get(baseUrl + "/api/spartans/3");

        Assertions.assertEquals(response.statusCode(), 200);
        Assertions.assertEquals(response.contentType(), "application/json");


    }

    @DisplayName("Nasıl olsa Herşeyin zamanla sonu vardır")
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON).when().get(baseUrl + "/api/spartans/3");

        Assertions.assertEquals(response.statusCode(), 200);
        Assertions.assertEquals(response.contentType(), "application/json");

        Assertions.assertEquals(response.header("Content-Type"),"application/json");
        Assertions.assertTrue(response.body().asString().contains("Fidole"));
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        Assertions.assertTrue(response.getStatusCode()>210);
    }


}
