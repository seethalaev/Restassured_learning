package Rest_basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Base.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Validate if Add place API is working as expected
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		//Add place ->update place with new address->get place to validate if new address is present in response
		System.out.println("response" +response);
		
		JsonPath js=new JsonPath(response);//for parsing
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		String newAddress = "Mylapravan veed,Kalliad";

		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		String getPlaceResponse=given().log().all().queryParam("key","qaclick123")
		.queryParam("placeid",placeid)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js2=new JsonPath(getPlaceResponse);
		String actualadrs=js2.getString("address");
		System.out.println(actualadrs);
		//Assert.assertEquals(actualadrs,newAddress);
		
		
}
}