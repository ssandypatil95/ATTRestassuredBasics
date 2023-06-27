package fetchdata;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicDataExtraction {
	

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
	
	int size = jp.getInt("data.size()");
	
	System.out.println(size);//6
	
	for(int i=0; i<size; i++)
	{
String lastname = jp.getString("data["+i+"].last_name");
		
//		System.out.println(lastname);
		
		if(lastname.equals("Ferguson"))
		{
			String email = jp.getString("data["+i+"].email");
			
			System.out.println(email);
		}
	}
	
		
	
	
		

	}


}
