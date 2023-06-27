package assertionsusage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ApplyAssertions {
	
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		
		given()
		
		.header("x-api-key", "api key")
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.assertThat()
		
		.header("Transfer-Encoding", "chunked")
		
		.contentType(ContentType.JSON)
		
		.statusCode(200)
				
		.body("workspaces.name", contains("Team Workspace", "My Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace"))
		
		
		.body("workspaces.name", hasItem("My Workspace"))// failed as hasItem parameter doesnt match with any of the values
		
		
		.body("workspaces.name", containsInAnyOrder( "My Workspace","Team Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace"));
	}
	
	
	

}
