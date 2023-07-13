package com.spotify.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import api.SpecBuilders;

public class CreatePlayListWithReqAndResSpec {
	
	
	@Test(priority = 1)
	 public void createPlayList()
	 {
		 
		 Playlist reqplaylist = new Playlist();
		 
		 reqplaylist.setName("ATT  Batch specbuilder playlist");
		 reqplaylist.setDescription("This is ATT optimization collection");
		 reqplaylist.setPublic(false);
		 
	Playlist responseplaylist = given(SpecBuilders.reqSpec())
		 
			
			
		 .body(reqplaylist)
		 
		 .when()
		 
		 .post("/users/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(SpecBuilders.resSpec())
		 
		 .extract()
		 
		 .response()
		 
		 .as(Playlist.class);
	
	
		 
	String namevalue = reqplaylist.getName();
	
	String nameresponse = responseplaylist.getName();
	
	Assert.assertEquals(namevalue, nameresponse);
		 
		 
		 
	 }
	 

}
