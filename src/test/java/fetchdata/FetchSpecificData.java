package fetchdata;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchSpecificData {
	
	
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
		
		String statusline = response.getStatusLine();
		
		System.out.println("Status line is "+statusline);
	
		
		JsonPath jp = response.jsonPath();
		
	int pagevalue = jp.getInt("page");
	
	System.out.println(pagevalue);
	
	
	for(int i=0; i<6; i++)
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
