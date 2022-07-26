package com.cybertek.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanWithAuthTestBase {
    @BeforeAll
    public static void init() {
        baseURI = ConfigurationReader.getProperties("SpartanbaseURIWithAuth");

    }


}
