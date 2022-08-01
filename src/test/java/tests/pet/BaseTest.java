package tests.pet;

import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {
    @BeforeTest
    public static void setup(){
        baseURI = "https://petstore.swagger.io/v2/";
    }
}
