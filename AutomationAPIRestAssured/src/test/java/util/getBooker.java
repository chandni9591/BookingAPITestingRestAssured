package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;

public class getBooker {

    @Test
   public void getBooking_01(){
       Response response= RestAssured.get("https://restful-booker.herokuapp.com/booking");
       System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println("Header : "+response.getHeader("content-type"));
        int ActualStatusCode=response.getStatusCode();
        assertEquals(HttpStatus.SC_OK,ActualStatusCode);

   }

   @Test
        void test_01(){
       // given().get("https://restful-booker.herokuapp.com/booking").then().statusCode(HttpStatus.SC_OK);
        given().get(" https://restful-booker.herokuapp.com/booking/1").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    void testGetBooking_02(){
        Response response =RestAssured.get(" https://restful-booker.herokuapp.com/booking/1");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

    }

    @Test
    void testGetBookingValidate_01(){
       // given().get("https://restful-booker.herokuapp.com/booking/2").then().body("firstname",hasItem("Mark")).statusCode(HttpStatus.SC_OK);

        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/2");
        response.then().body("firstname",equalTo("Jim"));


    }

}
