package com.cybertek.day4;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartanWithJsonPath extends SpartanTestBase {


    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON).and().pathParam("id", "10").
                when().get("api/spartans/{id}");

        assertEquals("application/json", response.contentType());
        assertEquals(200, response.getStatusCode());

        System.out.println("response.path(\"name\") = " + response.path("name"));

        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("name");
        System.out.println("name = " + name);

        int id = jsonPath.getInt("id");
        System.out.println("id = " + id);


    }
}
