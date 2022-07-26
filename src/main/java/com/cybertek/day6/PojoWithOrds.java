package com.cybertek.day6;

import com.cybertek.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PojoWithOrds extends HRTestBase {
    @Test
    public void test1(){
        JsonPath jsonPath = given().accept(ContentType.JSON).get("/regions").then().statusCode(200)
                .extract().jsonPath();

        Region object = jsonPath.getObject("items[0]", Region.class);
        System.out.println("object.getRegion_name() = " + object.getRegionName());

    }

    @Test
    public void test2(){
        JsonPath jsonPath = given().contentType(ContentType.JSON).get("/regions")
                .then().statusCode(200).extract().jsonPath();

       // System.out.println("jsonPath.prettyPrint() = " + jsonPath.prettyPrint());
        Region object = jsonPath.getObject("items[0]", Region.class);
        System.out.println("object = " + object);


    }
}
