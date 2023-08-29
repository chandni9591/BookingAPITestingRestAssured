package util;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutUpdateTest {
    @Test
    public void testPut_01(){
        baseURI="https://reqres.in/";
        Map map=new HashMap<>();
        map.put("name","morpheus");
        map.put("job","zion resident");
        System.out.println("Map is  :  "+map);
        JSONObject jsonobject =new JSONObject(map);
        System.out.println("Json Object is  :  "+jsonobject);
        given().contentType(ContentType.JSON).body(jsonobject.toJSONString()).when().put("api/users/2").then().statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testPatch_01(){
        baseURI="https://reqres.in/";
        Map map=new HashMap<>();
        map.put("name","morpheus");
        System.out.println("Map is : "+map);
        JSONObject jsonobject1=new JSONObject(map);
        System.out.println("Json object is  : "+jsonobject1);
        given().contentType(ContentType.JSON).body(jsonobject1.toJSONString()).when().patch("api/users/2").then().statusCode(200);

    }

}
