package tests.store;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pet.BaseTest;

import static io.restassured.RestAssured.given;

public class CreateOrder extends BaseTest {

    public String requestBody = "{\n" +
            "  \"id\": 110,\n" +
            "  \"petId\": 0,\n" +
            "  \"quantity\": 0,\n" +
            "  \"shipDate\": \"2022-08-01T18:20:16.139Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";

    @Test
    public void postCreateOrder(){
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("store/order")
                .then()
                .log()
                .all()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}
