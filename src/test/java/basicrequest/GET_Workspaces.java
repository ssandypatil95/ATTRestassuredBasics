package basicrequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_Workspaces {

	@Test
	public void getPostManWorkspaces() {
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given()

							.header("x-api-key", "<Api key>")

							.when()

							.get("/workspaces")

							.then()

							.extract()

							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);

	}

}
