package com.spotify.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import api.PlayListAPI;
import io.restassured.response.Response;

public class CreateAndGetPlayListUsingReusableCalls {
	
	static String playlistId;
	@Test(priority = 1)
	 public void createPlayList()
	 {
		 
		 Playlist reqplaylist = new Playlist();
		 
		 reqplaylist.setName("ATT Batch playlist using Automation");
		 reqplaylist.setDescription("This is ATT automation collection");
		 reqplaylist.setPublic(false);
		 
	Response response = PlayListAPI.post(reqplaylist);
	
	 Playlist responseplaylist = response.as(Playlist.class);
		 
	String namevalue = reqplaylist.getName();
	
	String nameresponse = responseplaylist.getName();
	
	  playlistId = responseplaylist.getId();
	
	Assert.assertEquals(namevalue, nameresponse);
		
		 
	 }
	 
	 


	 
	 @Test(priority = 2)
	 public void getAPlayList()
	 {
		 Playlist reqplaylist = new Playlist();
		 
		 reqplaylist.setName("ATT Batch playlist using Automation");
		 reqplaylist.setDescription("This is ATT automation collection");
		 reqplaylist.setPublic(false);
		 
		 Response response = PlayListAPI.get(playlistId);
		 Playlist responseplaylist = response.as(Playlist.class);
		 
		 Assert.assertEquals(responseplaylist.getName(), reqplaylist.getName());
		 
		 
	 }
	 
//	 Assignment to create the method for update playlist API
	 

}
