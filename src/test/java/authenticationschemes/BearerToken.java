package authenticationschemes;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BearerToken {
	
	
	
	@Test
	public void getAllRepository()
	{
		
			RestAssured.baseURI = "https://api.github.com";
			
			given()
			.header("Accept", "application/vnd.github+json")
			.header("X-GitHub-Api-Version", "2022-11-28")
			.header("Authorization", "Bearer PersonalAccessToken")
			
			.log().all()
			
			.when()
			
			.get("/user/repos")
			
			.then()
			
			.log().all();
		}

	}


