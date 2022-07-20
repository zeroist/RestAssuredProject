package com.cybertek.day6.pojo;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanPojoGetRequestTest extends SpartanTestBase {

    @Test
    public void oneSpartanPojo(){
        Response response = given().accept(ContentType.JSON).pathParam("id", 15)
                .get("/api/spartans/{id}").then()
                .statusCode(200).extract().response();



    }


}
