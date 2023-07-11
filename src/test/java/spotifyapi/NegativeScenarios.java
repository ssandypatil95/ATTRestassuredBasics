package spotifyapi;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class NegativeScenarios {
	
	 RequestSpecification requestspecification;
	 ResponseSpecification  responsespecification;
	
	 @BeforeClass
	public void reqResSpec()
	{
		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		
		requestspecbuilder.setBaseUri("https://api.spotify.com");
	
		requestspecbuilder.addHeader("Authorization", "Bearer BQCn0TUjZN-cdkaLJutYdAhJONLUQ0qRCnQT_htpNMhXavsZo0pQsU-sn17khw3gwwhWpcL07AyzIsDFdMXFvK9LgvbwfBbp2oQFVOUFSGeFAyHrNeoVwxHC21cFq3-SfzwXXOMwcb9GSQTf-1NKSgCnWAby4lcSku0gsfFV1-LR7q71yLMRnzEgcvsYwxN5wubhscMBRzGHVpqYWZpD-2voEWI7XEoB7hb5Rs29RjStVq-augbs71fclgElKwesXHrg0EGGEPaNqxqG");
		requestspecbuilder.log(LogDetail.ALL);
		 requestspecification = requestspecbuilder.build();
		 
		 
		 ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		 	 
		 responsespecbuilder.expectContentType(ContentType.JSON);
		 responsespecbuilder.log(LogDetail.ALL);
		 responsespecification	=  responsespecbuilder.build();
		 
	}
	 
	 
	 
	 @Test( enabled = false)
	 public void shouldNotBeAbleToCreatePlayList()
	 {
		 given(requestspecification)
		 
		 .body("{\r\n"
		 		+ "    \"name\": \"\",\r\n"
		 		+ "    \"description\": \"Retro songs collection\",\r\n"
		 		+ "    \"public\": false\r\n"
		 		+ "}")
		 
		 .when()
		 
		 .post("v1/users/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .assertThat()
		 
		 .statusCode(400);
	 
	 }
	 
	 
	 
	 @Test(priority = 2)
	 public void shouldNotBeAuthorized()
	 {
 given(requestspecification)
		 
		 .body("{\r\n"
		 		+ "    \"name\": \"Test create Playlist\",\r\n"
		 		+ "    \"description\": \"sample playlist\",\r\n"
		 		+ "    \"public\": false\r\n"
		 		+ "}")
		 
		 .when()
		 
		 .post("v1/users/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .assertThat()
		 
		 .statusCode(401);
	 }
	 
	
	

}
