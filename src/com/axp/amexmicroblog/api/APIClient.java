package com.axp.amexmicroblog.api;

import com.axp.amexmicroblog.Consts;

import android.util.Base64;
import retrofit.RestAdapter;

public class APIClient
{

	private static APIClient client;
	private static RestAdapter adapter;
	private static BlogAPI blogApi;
	private static String userName, passWord, authHeader;

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

			if (client == null)
			{
				client = new APIClient();

				blogApi = adapter.create(BlogAPI.class);

				userName = username;
				passWord = password;
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
		LoginResponse response = blogApi.Login(userName, authHeader);
		return response;
	}

	public String CreatePost(String message)
	{
		return blogApi.CreatePost(userName, message, authHeader);
	}

	public void SetUserStatus(String targetUser, boolean isFollow)
	{
		if (isFollow)
			 blogApi.FollowUser(userName, targetUser, authHeader);
		else
			 blogApi.UnFollowUser(userName, targetUser, authHeader);
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
