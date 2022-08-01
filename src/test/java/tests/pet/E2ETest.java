package tests.pet;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class E2ETest {

    private int id = 5466;

    private final HashMap<String, String> dataMap = new HashMap<>();


    @Test(priority = 1)
    public void createPet() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "  \"id\": " + this.id + ",\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"garry\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log()
                .all()
                .extract().response();

        dataMap.put("id", String.valueOf(id));
        Assert.assertEquals(200, response.statusCode());
    }

    @Test(priority = 2)
    public void getPetById(){
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + dataMap.get("id"))
                .then()
                .log()
                .all()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }

    @Test(priority = 3)
    public void deletePet() {
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + dataMap.get("id"))
                .then()
                .log()
                .all()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
    }
}
