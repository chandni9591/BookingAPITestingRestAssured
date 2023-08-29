package util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostTest {

    @Test
    public void postTest_01(){
        baseURI="https://reqres.in/";
        Map map=new HashMap<>();
        map.put("email","eve.holt@reqres.in");
        map.put("password","cityslicka");
        System.out.println("Map is  :  "+map);
        JSONObject jsonobject =new JSONObject(map);
        System.out.println("Json Object is  :  "+jsonobject);
        given().contentType(ContentType.JSON).body(jsonobject.toJSONString()).when().post("api/login").then().statusCode(HttpStatus.SC_OK);
        Response response= RestAssured.get("https://reqres.in/api/login");
        System.out.println(response.getBody().asString());

    }
}
