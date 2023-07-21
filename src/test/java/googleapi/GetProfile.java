package googleapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetProfile {
	
	@Test
	public void getProfile()
	{
		RestAssured.baseURI = "https://gmail.googleapis.com";
		
		given()
		
		.log().all()
		
		.auth().oauth2("ya29.a0AbVbY6NIVKhclTh5wnG97_YorUbVt7zis7m_AqB8GwKX0jrMAosdDH60JsdcqFcthWAyikwd7WfiQSazXPiTHrfIYKLt0_98XNooHneSHO1GXnZMlwNqRsPm6emta7_qcr-sEixEjcLLnwnY7_VIzg7fC-hYAcMaCgYKAbwSARMSFQFWKvPlM3bhUIRoyuEfTlmG9dgaXQ0166")
		
		.when()
		
		.get("/gmail/v1/users/gouravjawale27@gmail.com/profile")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	}

}
