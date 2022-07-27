package com.cybertek.day8;
import com.cybertek.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class BookitTest {

    @BeforeAll
    public static void init() {
        baseURI = "https://cybertek-reservation-api-qa3.herokuapp.com";

    }
String token="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNDAiLCJhdWQiOiJzdHVkZW50LXRlYW0tbGVhZGVyIn0.xNvdQRyrYMb3Ec5QByHwXowBo3zPK2jQQS1eJ2RYIto";

    @Test
    public void testAuth(){
        given().header("Authorization",token).contentType(ContentType.JSON)
                .get("/api/campuses").then().statusCode(200).log().body();



    }





}
