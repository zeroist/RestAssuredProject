package com.cybertek.day7;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PUTRequest extends SpartanTestBase {
    @Test
    public void test1() {
        Map<String, Object> putRequestMap = new LinkedHashMap<>();

        putRequestMap.put("name", "BruceWayne");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", 881111111111L);

        given().contentType(ContentType.JSON).body(putRequestMap).pathParam("id",388)
        .put("/api/spartans/{id}").then().statusCode(204);

    }

}
