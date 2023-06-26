package basicrequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchDataFromComplexJson {
	
	@Test
	public void fetchDetailsFromJson()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		
		Response response = given()
		
		.when()
		
		.get("/api/users?page=2")
		
		.then()
		
		.extract()
		
		.response();
	
		
		JsonPath jp = response.jsonPath();
		
	int pagevalue = jp.getInt("page");
	
	System.out.println(pagevalue);
		
	
//	Fetching the value of email from oth index position of array
	
	String emailvalue = jp.getString("data[0].email");
		
	
	System.out.println(emailvalue);
	}


}
