package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.CreateUserRequestBody;
import pojo.CreateUserResponseBody;

public class Create_User {
	

	

	@Test(priority = 1)
	public void createAUser() {
		
		CreateUserRequestBody requestObject = new CreateUserRequestBody();
		
		
		requestObject.setUsername("Pojouser2");
		requestObject.setFirstName("Pojo2");
		requestObject.setLastName("Classes2");
		requestObject.setEmail("pojo.classes2@gmail.com");
		requestObject.setPassword("Test@1234");
		requestObject.setPhone("9988769655");
		requestObject.setUserStatus(0);
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

CreateUserResponseBody responseBody = given()

				.body(requestObject)

				.header("Content-Type", "application/json")
				
				.log().all()

				.when()

				.post("/user")

				.then()

				.extract()

				.response().as(CreateUserResponseBody.class);


			Integer statusCode = responseBody.getCode();
			
			System.out.println(statusCode);
			
			System.out.println(responseBody.getMessage());
			
	}

}
