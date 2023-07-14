package com.spotify.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import api.PlayListAPI;
import authmanager.TokenCreator;
import io.restassured.response.Response;

public class CreateAndGetPlayListUsingReusableCalls {

	static String playlistId;

	@Test(priority = 1)
	public void createPlayList() {

		Playlist reqplaylist = new Playlist();

		reqplaylist.setName("ATT Batch july playlist");
		reqplaylist.setDescription("This is ATT collection");
		reqplaylist.setPublic(false);

		Response response = PlayListAPI.post(reqplaylist, TokenCreator.renewToken());

		Playlist responseplaylist = response.as(Playlist.class);

		String namevalue = reqplaylist.getName();

		String nameresponse = responseplaylist.getName();

		playlistId = responseplaylist.getId();

		Assert.assertEquals(namevalue, nameresponse);

	}

	@Test(priority = 2)
	public void getAPlayList() {
		Playlist reqplaylist = new Playlist();

		reqplaylist.setName("ATT Batch july playlist");
		reqplaylist.setDescription("This is ATT collection");
		reqplaylist.setPublic(false);

		Response response = PlayListAPI.get(playlistId, TokenCreator.renewToken());
		Playlist responseplaylist = response.as(Playlist.class);

		Assert.assertEquals(responseplaylist.getName(), reqplaylist.getName());

	}

//	 Assignment to create the method for update playlist API

	
	
	@Test(priority = 3)
	public void changeUserPlaylist()
	{
		Playlist reqplaylist = new Playlist();

		reqplaylist.setName("ATT Batch july playlist using RestAssured");
		reqplaylist.setDescription("This is ATT automation collection");
		reqplaylist.setPublic(false);
		
		Response response = PlayListAPI.update(playlistId, reqplaylist, TokenCreator.renewToken());
		
		
		int statuscode = response.statusCode();
		
		Assert.assertEquals(statuscode, 200);
	}
	
	@Test(priority = 4)
	public void shouldNotBeAbleToCreatePlaylist()
	{
		
		Playlist reqplaylist = new Playlist();

		reqplaylist.setName("ATT Batch july playlist using RestAssured");
		reqplaylist.setDescription("This is ATT automation collection");
		reqplaylist.setPublic(false);
		
		Response response = PlayListAPI.post(reqplaylist, "12345");

	int	stscode = response.statusCode();
	
		Assert.assertEquals(stscode, 401);
		 }
		 
	
}
