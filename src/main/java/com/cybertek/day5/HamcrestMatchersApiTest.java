package com.cybertek.day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {

    @Test
    public void test1() {
        given()
                .accept(ContentType.JSON)

                .pathParam("id", 15)

                .get("http://18.233.99.140:8000/api/spartans/{id}")

                .then()

                .statusCode(200)
                .header("Content-Type", is("application/json"))
                .header("Transfer-Encoding", is("chunked"))

                .contentType("application/json")

                .body(
                        "id", is(15),

                        "name", is("Meta"),

                        "gender", is("Female"),

                        "phone", is(1938695106)


                );


    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .get("http://api.cybertektraining.com/teacher/all")
                .then()
                .body("teachers.firstName",hasItems("Sharda","Wayne"));


    }


}
