package com.axp.amexmicroblog.api;

import com.axp.amexmicroblog.Consts;

import android.util.Base64;
import android.util.Log;
import retrofit.RestAdapter;

public class APIClient
{

	private static APIClient client;
	private static RestAdapter adapter;
	private static BlogAPI blogApi;
	private static String userName, authHeader;

	private APIClient()
	{

	}

	public static APIClient getInstance(String username, String password)
			throws Exception
	{
		// LoginResponse response = null;
		try
		{
			adapter = new RestAdapter.Builder().setEndpoint(Consts.LOGIN_API_URL).build();

			if (client == null || userName == null || authHeader == null || !username.equalsIgnoreCase(userName))
			{
				client = new APIClient();

				blogApi = adapter.create(BlogAPI.class);

				userName = username;
				authHeader = EncodePassword(username, password);

				return client;

			}
			else
				return client;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public LoginResponse GetMessageList()
	{
		Log.v(Consts.TAG, userName);
		Log.v(Consts.TAG, authHeader);
		LoginResponse response = blogApi.Login(userName, authHeader);
		return response;
	}

	public void CreatePost(String message)
	{
		blogApi.CreatePost(userName, message, authHeader);
	}

	public static void CreateUser(String username, String password)
	{
		if (blogApi == null)
		{
			adapter = new RestAdapter.Builder().setEndpoint(Consts.LOGIN_API_URL).build();
			blogApi = adapter.create(BlogAPI.class);
		}
		
		blogApi.CreateUser(username, password);
	}

	public void SetUserStatus(String targetUser, boolean isFollow)
	{
		if (isFollow)
			blogApi.FollowUser(userName, targetUser, authHeader);
		else
			blogApi.UnFollowUser(userName, targetUser, authHeader);
	}
	
	public String[] SearchUsers(String searchString)
	{
		return blogApi.SearchUser(searchString, authHeader);
	}

	public String[] GetFollowers()
	{
		String response[] = blogApi.GetUsersFollowed(userName, authHeader);

		return response;

	}

	private static String EncodePassword(String username, String password)
	{
		String auth = new String(Base64.encode((username + ":" + password).getBytes(), Base64.URL_SAFE
				| Base64.NO_WRAP));

		return "Basic " + auth;

	}

}
