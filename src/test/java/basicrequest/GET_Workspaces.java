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

							.header("x-api-key", "PMAK-649247a391dd760038ebbae5-207f6011b82179ae656d83cded68e7a595")

							.when()

							.get("/workspaces")

							.then()

							.extract()

							.response();
		
		String resp = response.asPrettyString();
		
		System.out.println(resp);

	}

}
