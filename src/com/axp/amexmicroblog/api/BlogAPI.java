package com.axp.amexmicroblog.api;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

public interface BlogAPI
{

	@GET("/postsforuser")
	LoginResponse Login(@Query("username") String username, @Header("Authorization") String header);

	@GET("/usersfollowed")
	String[] GetUsersFollowed(@Query("username") String username, @Header("Authorization") String header);

	@GET("/userslike")
	String[] SearchUser(@Query("username") String username, @Header("Authorization") String header);

	@POST("/followuser")
	@FormUrlEncoded
	Object FollowUser(@Field("username") String username, @Field("targetuser") String targetuser, @Header("Authorization") String header);

	@POST("/unfollowuser")
	@FormUrlEncoded
	Object UnFollowUser(@Field("username") String username,  @Field("targetuser") String targetuser, @Header("Authorization") String header);

	@POST("/createPost")
	@FormUrlEncoded
	String CreatePost(@Field("username") String username, @Field("message") String postMessage, @Header("Authorization") String header);

	@POST("/createuser")
	@FormUrlEncoded
	String CreateUser(@Field("username") String username, @Field("plainTextPassword") String password);

}
