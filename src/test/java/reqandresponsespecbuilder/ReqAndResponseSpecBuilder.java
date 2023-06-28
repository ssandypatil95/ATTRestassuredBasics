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
		requestspecbuilder.addHeader("x-api-key", "PMAK-649b8f542e0e150039ce53ab-df952b0fae2117528d2af1826d5560905c");
		requestspecbuilder.log(LogDetail.ALL);
		requestspecification = requestspecbuilder.build();
		
		ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		responsespecbuilder.expectStatusCode(200);
		responsespecbuilder.expectContentType(ContentType.JSON);
		responsespecbuilder.log(LogDetail.ALL);
			
		 responsespecification = responsespecbuilder.build();
		
		
		
	}
	
	
	
	
	@Test
	public void getPostManWorkspaces() {
							given(requestspecification)
						
							.when()

							.get("/workspaces")

							.then()
							
							.spec(responsespecification)

							.extract()

							.response();
	

	}


}
