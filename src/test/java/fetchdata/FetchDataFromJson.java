package fetchdata;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class FetchDataFromJson {
	
	@Test
	public void fetchDetailsFromJson()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		
		Response response = given()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.extract()
		
		.response();
	
		
		JsonPath jp = response.jsonPath();
		
	String firstname = jp.getString("data.first_name");
	
	System.out.println(firstname);
		
		
	}

}
