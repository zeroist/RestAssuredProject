package com.cybertek.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {
String url="http://18.233.99.140:8000/api/spartans";
    @Test
    public void test1(){

        Response response = RestAssured.get(url);

        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        response.prettyPrint();


    }
}
