package com.spotify.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

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
		requestspecbuilder.addHeader("Authorization", "Bearer BQB_EMYlDSRRjja_pqQka2euq0wV-GVER2XcY-nBDUgZwM4wQEeJ9rjut4twFfr37Oolluv3towg0_ZKM9MqQiB3E5btCXvvAB0bygHY7WJhE_vGla1-vpSN_h64_sOCgNfyugxmdHQfVl9xLzu6OctgXUtuwjd6TnJoYpyzZhQsc_sx3xI1WXpLSd36qq9sFF_6NsR-kWWleXW6qFezK1HjZvYWldxX58qU9E2aHBEc82WIz_3v0m6VbmHqvmpru-s6WqBieYefWh33");
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
		 
		 Playlist reqplaylist = new Playlist();
		 
		 reqplaylist.setName("Bhajan songs");
		 reqplaylist.setDescription("This is bhajan collection");
		 reqplaylist.setPublic(false);
		 
	Playlist responseplaylist = given(requestspecification)
		 
		 .body(reqplaylist)
		 
		 .when()
		 
		 .post("/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .extract()
		 
		 .response()
		 
		 .as(Playlist.class);
	
	
		 
	String namevalue = reqplaylist.getName();
	
	String nameresponse = responseplaylist.getName();
	
	Assert.assertEquals(namevalue, nameresponse);
		 
		 
		 
	 }

}
