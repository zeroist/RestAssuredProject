package com.cybertek.day6.pojo1;

import com.cybertek.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class OrdsPracticeWithPojo extends HRTestBase {


    @Test
    public void test1(){
        Regions regions = given().get("/regions").then().statusCode(200)
                .extract().response().as(Regions.class);


        for (Item item : regions.getItems()) {
            System.out.println(item.getRegion_name());
        }
        System.out.println("regions.getCount() = " + regions.getCount());
        System.out.println("regions.isHasMore() = " + regions.isHasMore());
        System.out.println("regions.getItems() = " + regions.getItems());
        System.out.println("regions.getLinks().get(0) = " + regions.getLinks().get(0));



    }
}
