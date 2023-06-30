package pathandqueryparam;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class QueryParameter {
	
	
	
	@Test
	public void getAllUsers()
	{
		HashMap<String, String> qp = new HashMap<String, String>();
		
		qp.put("page", "2");
				
		RestAssured.baseURI = "https://reqres.in";
		
		 given()
//	inserting query parameter using method queryParam()	
//		.queryParam("page", "2")
		 
//		 inserting query parameter using method queryParams()
		 
		 .queryParams(qp)
		 
			
		.log().all()
		
		.when()
		
		.get("api/users")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
				
	}

}
