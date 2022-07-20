package com.cybertek.day5;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneSpartanToMap extends SpartanTestBase {
    @Test
    public void test() {
        Response response = given().accept(ContentType.JSON).pathParam("id", 15)
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200).extract().response();

        Map<String, Object> jsonMap = response.as(Map.class);

        System.out.println("mapResponde = " + jsonMap);

    }

    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON).get("api/spartans").then()
                .statusCode(200).extract().response();

        List<Map<String,Object>> as = response.as(List.class);

        System.out.println("as.get(1).get(\"name\") = " + as.get(1).get("name"));


    }

}
