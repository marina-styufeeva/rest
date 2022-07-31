package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePet {

    @Test
    public void deletePet(){
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/5467")
                .then()
                .log()
                .all()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
    }
}
