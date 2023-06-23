package basicrequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_SingleUser {
	
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
				
	Response response = given()	
		
						.when()
		
						.get("/api/users/2")
		
						.then()
		
						.extract()
		
						.response();
		
	
	
	String resp = response.asPrettyString();
	
	System.out.println(resp);
	
	int statuscode = response.getStatusCode();
	
	System.out.println(statuscode);//200
	
	long time = response.getTime();// time taken
	
	System.out.println(time);
	
	}

}
