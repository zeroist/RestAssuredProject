package com.cybertek.day6;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SpartanPojoGetRequestTest extends SpartanTestBase {

    @Test
    public void oneSpartanPojo(){
        Response response = given().accept(ContentType.JSON).pathParam("id", 15)
                .get("/api/spartans/{id}").then()
                .statusCode(200).extract().response();

        Spartan spartan = response.as(Spartan.class);

        System.out.println("spartan.toString() = " + spartan.toString());
        System.out.println("spartan.getGender() = " + spartan.getGender());
        System.out.println("spartan.getName() = " + spartan.getName());

    }

    @Test
    public void spartanSearchWithPojo(){
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .queryParams("nameContains", "a", "gender", "female")
                .get("/api/spartans/search").then().statusCode(200).extract().jsonPath();

        Spartan object = jsonPath.getObject("content[0]", Spartan.class);

        System.out.println("object.toString() = " + object.toString());
        System.out.println("object.getName() = " + object.getName());
        System.out.println("object.getGender() = " + object.getGender());


    }
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .queryParams("nameContains", "a", "gender", "female")
                .get("/api/spartans/search").then().statusCode(200).extract().response();

        Search searchResult = response.as(Search.class);

        System.out.println("searchResult.getContent().get(1).getName() = " + searchResult.getContent().get(1).getName());


    }
    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .get("/api/spartans/search")
                .then().statusCode(200).extract().response();

        Search searchResult = response.as(Search.class);
        List<Spartan> list = searchResult.getContent();
        int i=1;
        for (Spartan spartan : list) {

            System.out.println(""+i+"spartan.getName() = " + spartan.getName());
            i++;
        }

    }


}
