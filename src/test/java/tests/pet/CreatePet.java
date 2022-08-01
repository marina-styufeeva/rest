package tests.pet;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pet.BaseTest;

import static io.restassured.RestAssured.given;

public class CreatePet extends BaseTest {

    private static String requestBody = "{\\n\" +\n" +
            "                        \"  \\\"id\\\": 5467,\\n\" +\n" +
            "                        \"  \\\"category\\\": {\\n\" +\n" +
            "                        \"    \\\"id\\\": 0,\\n\" +\n" +
            "                        \"    \\\"name\\\": \\\"string\\\"\\n\" +\n" +
            "                        \"  },\\n\" +\n" +
            "                        \"  \\\"name\\\": \\\"larry\\\",\\n\" +\n" +
            "                        \"  \\\"photoUrls\\\": [\\n\" +\n" +
            "                        \"    \\\"string\\\"\\n\" +\n" +
            "                        \"  ],\\n\" +\n" +
            "                        \"  \\\"tags\\\": [\\n\" +\n" +
            "                        \"    {\\n\" +\n" +
            "                        \"      \\\"id\\\": 0,\\n\" +\n" +
            "                        \"      \\\"name\\\": \\\"string\\\"\\n\" +\n" +
            "                        \"    }\\n\" +\n" +
            "                        \"  ],\\n\" +\n" +
            "                        \"  \\\"status\\\": \\\"available\\\"\\n\" +\n" +
            "                        \"}";

    @Test
    public void createPet(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("pet")
                .then()
                .log()
                .all()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("available", response.jsonPath().getString("status"));
        Assert.assertNotEquals("sold", response.jsonPath().getString("status"));
    }
}