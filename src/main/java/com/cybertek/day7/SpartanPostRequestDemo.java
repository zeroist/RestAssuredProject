package com.cybertek.day7;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPostRequestDemo extends SpartanTestBase {
    @Test
    public void test1(){
        String jsonBody="        {\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"YusufOlgun113\",\n" +
                "  \"phone\": 5304647559\n" +
                "}";
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonBody)
                .post("/api/spartans").then().statusCode(201).extract().response();

        System.out.println("response.path(\"data.name\") = " + response.path("data.name"));



        /*
        {
  "gender": "Male",
  "name": "YusufOlgun13",
  "phone": 5304647559
}
         */



    }


}
