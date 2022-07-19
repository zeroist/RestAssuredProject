package com.cybertek.day5;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class OneSpartanToMap extends SpartanTestBase {
    @Test
    public void test(){
        Response response = given().accept(ContentType.JSON).pathParam("id", 15)
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200).extract().response();

        Map<String,Object> jsonMap =response.as(Map.class);

        System.out.println("mapResponde = " + jsonMap);


    }

}
