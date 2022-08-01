package tests.pet;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPet {

    @Test
    public void getPet(){
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
                .then()
                .log()
                .all()
                .extract().response(); // - выполни запрос

        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void getPetById(){
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/5467")
                .then()
                .log()
                .all()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}
