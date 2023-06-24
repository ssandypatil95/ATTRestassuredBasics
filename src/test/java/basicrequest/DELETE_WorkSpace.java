package basicrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DELETE_WorkSpace {

	@Test
	public void deleteWorkspace() {
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given()

				.header("x-api-key", "api key")

				.when()

				.delete("/workspaces/c636d825-699a-418c-ab41-6bac8c01c6c1")

				.then()

				.extract()

				.response();
		
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);

	}

}
