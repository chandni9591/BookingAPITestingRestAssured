package util;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteOperationTest {
    @Test
    public void deleteTest_01(){
        baseURI="https://restful-booker.herokuapp.com/";
        given().when().delete("booking/2").then().statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
