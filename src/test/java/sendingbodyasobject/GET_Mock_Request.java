package sendingbodyasobject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class GET_Mock_Request {

	
	@Test
	public void getRequest()
	{
		RestAssured.baseURI = "https://02bb9a44-db49-4734-9c5b-7991b066bb5a.mock.pstmn.io";
		
		given()
		
		.log().all()
		
		.when()
		
		.get("/get")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	
	
	
}
