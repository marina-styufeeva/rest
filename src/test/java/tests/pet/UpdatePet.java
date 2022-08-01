package tests.pet;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdatePet {
    @Test
    public void updatePet(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "  \"id\": 5467,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"larry\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"sold\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .log()
                .all()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}
