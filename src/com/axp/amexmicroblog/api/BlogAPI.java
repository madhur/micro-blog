package com.axp.amexmicroblog.api;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

public interface BlogAPI
{

	@GET("/postsforuser")
	LoginResponse Login(@Query("username") String username, @Header("Authorization") String header);

	@GET("/usersfollowed")
	ArrayList<String> GetUsersFollowed(@Query("username") String username, @Header("Authorization") String header);

	@GET("/userslike")
	ArrayList<String> SearchUser(@Query("username") String username, @Header("Authorization") String header);

	@POST("/followuser")
	void FollowUser(@Query("username") String username, String targetuser, @Header("Authorization") String header);

	@POST("/unfollowuser")
	void UnFollowUser(@Query("username") String username, String targetuser, @Header("Authorization") String header);

	@POST("/createPost")
	void CreatePost(@Query("username") String username, String postMessage, @Header("Authorization") String header);

	@POST("/createuser")
	void CreateUser(@Query("username") String username, String password);

}
