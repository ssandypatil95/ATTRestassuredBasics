package api;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlayListAPI {

	public static Response post(Playlist requestPlaylist) {
		
		return given(SpecBuilders.reqSpec())

				.body(requestPlaylist)

				.when()

				.post("/users/31q36j7z4gu5fg2mawtfmlskhp74/playlists")

				.then()

				.spec(SpecBuilders.resSpec())

				.extract()

				.response();
	}
	
	
	public static Response get(String playlistId)
	{
		return given(SpecBuilders.reqSpec())
		 
		 .when()
		 
		 .get("/playlists/"+playlistId)
		 
		 .then()
		 
		 .spec(SpecBuilders.resSpec())
		 
		 .extract()
		 
		 .response();
		
	}
	
	
	

}
