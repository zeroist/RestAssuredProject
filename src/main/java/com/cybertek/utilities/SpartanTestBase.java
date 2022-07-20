package com.cybertek.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init() {
        baseURI = ConfigurationReader.getProperties("SpartanbaseURI");

        String dbUrl = "jdbc:oracle:thin:@18.233.99.140:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";

        DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

    }

    @AfterAll
    public static void tearDown(){

        DBUtils.destroy();
    }
}
