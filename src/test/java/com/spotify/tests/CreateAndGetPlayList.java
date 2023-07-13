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

public class CreateAndGetPlayList {
	
	static String playlistId;
	
	RequestSpecification requestspecification;
	 ResponseSpecification    responsespecification;
	
	 @BeforeClass
	public void reqResSpec()
	{
		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		
		requestspecbuilder.setBaseUri("https://api.spotify.com");
		requestspecbuilder.setBasePath("/v1");
		requestspecbuilder.setContentType(ContentType.JSON);
		requestspecbuilder.addHeader("Authorization", "Bearer BQDbg2nseWfB3_bn-3UBNVpCGgxeMGp35wWYtJfwGVZg6azixwTwMhCjG-ddKqdqnHkJe_KazDNntc6JMaMa_ga1Gj3gTB25Vk5B3CAMfkqSY8jlXFIIUEWf_ctz1Whdrmxa0FoixSW-IabVGuPO2M0jhp1YmB--e7c_hB4x-PFse5pJ9VNBpz01RMUnFHdovtHMlUgWkX_ihVw-vU1a_IF_fzw3tFlX-L_LkE9qI3O4MkjgaERqROHpfJ5mMzpmsoA_66zCh-YQyk96");
		requestspecbuilder.log(LogDetail.ALL);
		 requestspecification = requestspecbuilder.build();
		 
		  
		 ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		 	 
		 responsespecbuilder.expectContentType(ContentType.JSON);
		 responsespecbuilder.log(LogDetail.ALL);
		 responsespecification	=  responsespecbuilder.build();
		 
	}
	
	
	 
	 @Test(priority = 1)
	 public void createPlayList()
	 {
		 
		 Playlist reqplaylist = new Playlist();
		 
		 reqplaylist.setName("ATT Batch playlist");
		 reqplaylist.setDescription("This is ATT collection");
		 reqplaylist.setPublic(false);
		 
	Playlist responseplaylist = given(requestspecification)
		 
		 .body(reqplaylist)
		 
		 .when()
		 
		 .post("/users/31q36j7z4gu5fg2mawtfmlskhp74/playlists")
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .extract()
		 
		 .response()
		 
		 .as(Playlist.class);
	
	
		 
	String namevalue = reqplaylist.getName();
	
	String nameresponse = responseplaylist.getName();
	
	 playlistId = responseplaylist.getId();
	
	Assert.assertEquals(namevalue, nameresponse);
		 
		 
		 
	 }
	 
	 


	 
	 @Test(priority = 2)
	 public void getAPlayList()
	 {
		 
		 given(requestspecification)
		 
		 .when()
		 
		 .get("/playlists/"+playlistId)
		 
		 .then()
		 
		 .spec(responsespecification)
		 
		 .extract()
		 
		 .response();
		 
		 
		 
		 
	 }
	 

}
