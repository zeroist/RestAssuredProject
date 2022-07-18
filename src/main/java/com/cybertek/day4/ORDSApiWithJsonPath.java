package com.cybertek.day4;

import com.cybertek.utilities.HRTestBase;
import com.cybertek.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HRTestBase {

    @Test
    public void test1() {

        Response response = get("/countries");

        JsonPath jsonPath = response.jsonPath();


        String secondcountry = jsonPath.getString("items[1].country_name");

        System.out.println("secondcountry = " + secondcountry);

        List<Object> list = jsonPath.getList("items.country_id");

        System.out.println("list = " + list);

        List<Object> list1 = jsonPath.getList("items.country_name");
        List<String> listOfCountriedOfTwo = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            String itemsNO = "items[" + i + "]";
            if (jsonPath.getInt(itemsNO + ".region_id") == 2) {
                listOfCountriedOfTwo.add(jsonPath.getString(itemsNO + ".country_name"));
            }


        }
        System.out.println("listOfCountriedOfTwo = " + listOfCountriedOfTwo);


    }

    @Test
    public void test2(){
        Response response = given().param("limit", 106).when().
                get("/employees?limit=107");

        JsonPath jsonPath = response.jsonPath();

        System.out.println("jsonPath.getString(\"items[1].email\") = " + jsonPath.getString("items[1].email"));

        System.out.println("jsonPath.getList(\"itemsAll.email\") = " + jsonPath.getList("items.email").toString());

        System.out.println("jsonPath.getList(\"itemsFiltered.email\") = " + jsonPath.

                getList("items.findAll {it.job_id.equals('IT_PROG')}.email").toString());

        List<Object> list = jsonPath.getList("items.first_name");

        System.out.println(list);
        List<Object> list1 = jsonPath.getList("items.findAll {it.salary>10000}.first_name");
        System.out.println("list1 = " + list1);


    }


}
