package Rest_Basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Base.Payload;
import io.restassured.RestAssured;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Validate if Add place API is working as expected
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payload.AddPlace()).when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)")
				;
		
		//Add place ->update place with new address->get place to validate if new address is present in response
		
	}

}
