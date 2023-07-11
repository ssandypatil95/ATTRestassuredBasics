package spotifyapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetUserDetails {
	
	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://api.spotify.com";
		
		given()
		
		.header("Authorization", "Bearer BQCn0TUjZN-cdkaLJutYdAhJONLUQ0qRCnQT_htpNMhXavsZo0pQsU-sn17khw3gwwhWpcL07AyzIsDFdMXFvK9LgvbwfBbp2oQFVOUFSGeFAyHrNeoVwxHC21cFq3-SfzwXXOMwcb9GSQTf-1NKSgCnWAby4lcSku0gsfFV1-LR7q71yLMRnzEgcvsYwxN5wubhscMBRzGHVpqYWZpD-2voEWI7XEoB7hb5Rs29RjStVq-augbs71fclgElKwesXHrg0EGGEPaNqxqG")
		
		.log().all()
		.when()
		
		.get("v1/me")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
		
		
	}

}
