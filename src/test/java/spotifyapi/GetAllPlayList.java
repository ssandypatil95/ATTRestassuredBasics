package spotifyapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

public class GetAllPlayList {
	
	
	@Test
	public void getAllPlaylist()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1/me/playlists";
		
		given()
		
		.header("Authorization", "Bearer BQBJd_wZIKUZeZa3-X5ub_IPgJ6PJ30Xilon7QAdyL6gD4KJTUlp7BWrHkwVHw2hOqbCwS5ER4kQRjUPBGcHjZ4t54_h4xu9xyQLD-P4nGyGOrtEltfdawhLEs_hfSsha-_PQfl8ImQkLP7rBd5AD8rcrblf9ettQrPhTcGw6MzjSuljUIj4YCrfHUDYylUegRMQ9bYC9iCUgt92hVO_njJ80U8fH1nD8qLepQP7OGYp8IjSe0YFEhctFn4V7Hmkqtw2xcsuW2v1Ya-D")
	
		.when()
		
		.get()
		
		.then()
		
		.log().all()
		
		.extract()
				
		.response();
	}

}
