package com.cybertek.day8;

import com.cybertek.utilities.SpartanWithAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class SpartanWithAuthTests extends SpartanWithAuthTestBase {
@Test
    public void test(){
get("api/spartans").then().statusCode(401).log().all();

}

    @Test
    public void test2(){
        given().auth().basic("admin","admin").contentType(ContentType.JSON)
                .get("api/spartans").then().statusCode(200).log().all();

    }
    @Test
    public void test3(){

given().auth().basic("editor","editor").pathParam("id",30)
        .delete("/api/spartans/{id}").then().statusCode(403).log().body();


    }

}
