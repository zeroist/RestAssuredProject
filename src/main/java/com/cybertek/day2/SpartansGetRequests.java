package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartansGetRequests {


   String baseUrl= "http://18.233.99.140:8000";

@Test
    public void test1(){

   Response response = RestAssured.given().accept(ContentType.JSON).when().get(baseUrl + "/api/spartans");

    Assertions.assertEquals(response.statusCode(),200);
    Assertions.assertEquals(response.contentType(),"application/json");



}




}
