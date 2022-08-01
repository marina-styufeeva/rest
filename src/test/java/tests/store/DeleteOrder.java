package tests.store;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.pet.BaseTest;

import static io.restassured.RestAssured.given;

public class DeleteOrder extends BaseTest {

    private int id = 110;

    @Test
    public void deleteOrder(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("store/order/" + this.id)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }
}
