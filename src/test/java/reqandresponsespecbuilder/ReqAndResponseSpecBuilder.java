package reqandresponsespecbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqAndResponseSpecBuilder {
	
	RequestSpecification requestspecification;
	ResponseSpecification responsespecification;
	@BeforeClass
	public void initReqAndResSpec()
	{
		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		
		requestspecbuilder.setBaseUri("https://api.getpostman.com");
		requestspecbuilder.addHeader("x-api-key", "PMAK-649e32e4bad26a00385ec244-e5462dda14c5943e68ebed9a444c9e25d0");
		requestspecbuilder.log(LogDetail.ALL);
		requestspecification = requestspecbuilder.build();
		
		ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		responsespecbuilder.expectStatusCode(200);
		responsespecbuilder.expectContentType(ContentType.JSON);
		responsespecbuilder.log(LogDetail.ALL);
			
		 responsespecification = responsespecbuilder.build();
		
		
		
	}
	
	
	
	
	@Test(priority = 1)
	public void getPostManWorkspaces() {
							given()
							
							.spec(requestspecification)
						
							.when()

							.get("/workspaces")

							.then()
							
							.spec(responsespecification)

							.extract()

							.response();
	

	}
	
	@Test(priority = 2)
	public void getSpecificWorkspaceDetails()
	{
		given()
		
		.spec(requestspecification)
		
		.when()

		.get("/workspaces/8e12339e-b561-4326-90db-29384205056e")

		.then()
		
		.spec(responsespecification)

		.extract()

		.response();
		
	}


}
