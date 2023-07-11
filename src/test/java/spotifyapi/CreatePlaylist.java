package spotifyapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class CreatePlaylist {
	RequestSpecification requestspecification;
	 ResponseSpecification    responsespecification;
	
	 @BeforeClass
	public void reqResSpec()
	{
		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		
		requestspecbuilder.setBaseUri("https://api.spotify.com");
		requestspecbuilder.setBasePath("/v1/users");
		requestspecbuilder.setContentType(ContentType.JSON);
		requestspecbuilder.addHeader("Authorization", "Bearer BQBJd_wZIKUZeZa3-X5ub_IPgJ6PJ30Xilon7QAdyL6gD4KJTUlp7BWrHkwVHw2hOqbCwS5ER4kQRjUPBGcHjZ4t54_h4xu9xyQLD-P4nGyGOrtEltfdawhLEs_hfSsha-_PQfl8ImQkLP7rBd5AD8rcrblf9ettQrPhTcGw6MzjSuljUIj4YCrfHUDYylUegRMQ9bYC9iCUgt92hVO_njJ80U8fH1nD8qLepQP7OGYp8IjSe0YFEhctFn4V7Hmkqtw2xcsuW2v1Ya-D");
		requestspecbuilder.log(LogDetail.ALL);
		 requestspecification = requestspecbuilder.build();
		 
		 
		 ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		 	 
		 responsespecbuilder.expectContentType(ContentType.JSON);
		 responsespecbuilder.log(LogDetail.ALL);
		 responsespecification	=  responsespecbuilder.build();
		 
	}
	
	
	 
	 @Test
	 public void createPlayList()
	 {
		 
		 given(requestspecification)
		 
		 .body("{\r\n"
		 		+ "    \"name\": \"Hits 2022\",\r\n"
		 		+ "    \"description\": \"Latest songs collection of 2022\",\r\n"
		 		+ "    \"public\": false\r\n"
		 		+ "}")
		 
		 .when()
		 
		 .post("/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .body("name", equalTo("Hits 2022"));
		 
		 
		 
	 }

}
