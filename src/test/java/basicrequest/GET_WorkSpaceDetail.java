package basicrequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_WorkSpaceDetail {
	
	
	@Test
	public void getAWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given()

							.header("x-api-key", "<api_key>")

							.when()

							.get("/workspaces/65e9e49b-22be-4b83-bd7b-254713445f5b")

							.then()

							.extract()

							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);

	}

}
