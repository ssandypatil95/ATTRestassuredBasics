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
		
		.header("x-api-key", "PMAK-649b8f542e0e150039ce53ab-df952b0fae2117528d2af1826d5560905c")
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.assertThat()
		
		.header("Transfer-Encoding", "chunked")
		
		.contentType(ContentType.JSON)
		
		.statusCode(200)
				
		.body("workspaces.name", contains("Team Workspace", "My Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace", "Test Workspace"))
		
		
		.body("workspaces.name", hasItem("My Workspace"))// failed as hasItem parameter doesnt match with any of the values
		
		
		.body("workspaces.name", containsInAnyOrder("My Workspace","Team Workspace", "My Workspace", "ATTWorkspace", "TestWorkspace", "Test Workspace"))
		
		.body("workspaces[1]", hasKey("id"))// if we have id available then it will mark the case as passed
	
	
		.body("workspaces[1]", hasEntry("id", "8e12339e-c561-4326-90db-29384205056e"));
	
	}
	
	
	

}
