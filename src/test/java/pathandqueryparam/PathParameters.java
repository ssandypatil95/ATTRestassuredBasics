package pathandqueryparam;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParameters {
	
	

	@Test
	public void getSinglePageUser()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		 given()
		 
		 .pathParam("pagevalue", "2")
		 		 
		 .log().all()
		
		.when()
		
		.get("/api/users/{pagevalue}")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
				
	}

}
