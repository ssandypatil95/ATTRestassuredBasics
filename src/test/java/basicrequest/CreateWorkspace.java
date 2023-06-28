package basicrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateWorkspace {
	

	@Test
	public void createWorkpace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		Response resp = given()
		
		.header("x-api-key", "PMAK-649247a391dd760038ebbae5-207f6011b82179ae656d83cded68e7a595")
		
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"TestWorkspace\",\r\n"
				+ "        \"description\": \"Test workspace by code\",\r\n"
				+ "        \"type\": \"personal\"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.when()
		
		.post("/workspaces")
		
		.then()
		
		.extract()
		
		.response();
		
		String response = resp.asPrettyString();
		
		System.out.println(response);
		
	}

}
