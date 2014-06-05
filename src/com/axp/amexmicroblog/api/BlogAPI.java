package com.axp.amexmicroblog.api;


import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface BlogAPI {
	
	
	@GET("/postsforuser")
	LoginResponse Login(@Query("username") String username, @Header("Authorization") String header);
}
