package reqandresponsespecbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqResSpecBuilder {
	
	
	@Test
	public void getPostManWorkspaces() {
		RestAssured.baseURI = "https://api.getpostman.com";

		Response response = given()

							.header("x-api-key", "PMAK-649b8f542e0e150039ce53ab-df952b0fae2117528d2af1826d5560905c")

							.log().all()
							
							.when()

							.get("/workspaces")

							.then()
							
							.log().all()

							.extract()

							.response();
		
	

	}

}
