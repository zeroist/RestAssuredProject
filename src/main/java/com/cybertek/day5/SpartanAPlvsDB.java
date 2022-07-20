package com.cybertek.day5;

import com.cybertek.utilities.DBUtils;
import com.cybertek.utilities.SpartanTestBase;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpartanAPlvsDB extends SpartanTestBase {

    @Test
    public void test1(){
        Map<String, Object> rowMap = DBUtils.getRowMap("SELECT spartan_id,name,gender,phone FROM  SPARTANS WHERE SPARTAN_ID=15");
        System.out.println("rowMap = " + rowMap);

    }
}
