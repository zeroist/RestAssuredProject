package com.cybertek.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    @Test
    public void test1(){

        Response response = RestAssured.get("http://18.233.99.140:8000/api/spartans");




    }
}
