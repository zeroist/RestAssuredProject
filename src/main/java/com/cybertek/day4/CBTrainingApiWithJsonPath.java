package com.cybertek.day4;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CBTrainingApiWithJsonPath {

    @BeforeAll
    public static void init() {
        baseURI = "http://api.cybertektraining.com/";

    }

    @Test
    public void test() {
        Response response = given().pathParam("id", 32801).
                when().get("/student/{id}");


        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("students[0].firstName"));


        System.out.println(jsonPath.getString("students[0].batch"));

        Assertions.assertEquals(14, jsonPath.getInt("students[0].batch"));


        Assertions.assertEquals("Vera", jsonPath.getString("students[0].firstName"));


        System.out.println(jsonPath.getString("students[0].section"));

        Assertions.assertEquals("12", jsonPath.getString("students[0].section"));

        System.out.println(jsonPath.getString("students[0].contact.emailAddress"));

        Assertions.assertEquals("aaa@gmail.com", jsonPath.getString("students[0].contact.emailAddress"));


        System.out.println(jsonPath.getString("students[0].company.companyName"));

        Assertions.assertEquals("Cybertek", jsonPath.getString("students[0].company.companyName"));

        System.out.println(jsonPath.getString("students[0].company.address.state"));

        Assertions.assertEquals("IL", jsonPath.getString("students[0].company.address.state"));

        System.out.println(jsonPath.getString("students[0].company.address.zipCode"));

        Assertions.assertEquals(60606, jsonPath.getInt("students[0].company.address.zipCode"));


    }


}
