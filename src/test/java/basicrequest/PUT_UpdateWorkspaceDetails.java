package basicrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PUT_UpdateWorkspaceDetails {
	
	
	
	@Test
	public void updateDetails()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		
		Response response = given()
		
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"UpdatedRestAssuredWSByCode\",\r\n"
				+ "        \"description\": \"Testing PUT request by updating from Eclipse\",\r\n"
				+ "        \"type\": \"personal\"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.header("x-api-key", "<api key>")
		
		.when()
		
		.put("workspaces/65e9e49b-22be-4b83-bd7b-254713445f5b")
		
		.then()
		
		.extract()
		
		.response();
		
String resp	= 	response.asPrettyString();

System.out.println(resp);
		

		
		
		
	}

}
