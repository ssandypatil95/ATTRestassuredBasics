package googleapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SendEmail {
	
	@Test
	public void sendEmail()
	{
RestAssured.baseURI = "https://gmail.googleapis.com";
		
		given()
		
		.body("{\r\n"
				+ "\r\n"
				+ "    \"raw\" : \"RnJvbTogZ291cmF2amF3YWxlMjdAZ21haWwuY29tDQpUbzogZ291cmF2amF3YWxlQGdtYWlsLmNvbQ0KU3ViamVjdDogVGhpcyBpcyBhbiBlbWFpbCBzZW50IGZyb20gdXNpbmcgUmVzdEFzc3VyZWQNCg0KVGhpcyBpcyB0aGUgdGVzdCBlbWFpbCBmcm9tIHNlbmRlcg==\"\r\n"
				+ "}")
		
		.log().all()
		
		.auth().oauth2("ya29.a0AbVbY6NIVKhclTh5wnG97_YorUbVt7zis7m_AqB8GwKX0jrMAosdDH60JsdcqFcthWAyikwd7WfiQSazXPiTHrfIYKLt0_98XNooHneSHO1GXnZMlwNqRsPm6emta7_qcr-sEixEjcLLnwnY7_VIzg7fC-hYAcMaCgYKAbwSARMSFQFWKvPlM3bhUIRoyuEfTlmG9dgaXQ0166")
		
		.when()
		
		.post("/gmail/v1/users/gouravjawale27@gmail.com/messages/send")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	}


}
