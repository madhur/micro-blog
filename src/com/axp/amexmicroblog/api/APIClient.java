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
	private static LoginResponse response;

	private APIClient()
	{

	}

	public static LoginResponse getInstance(String username, String password)
			throws Exception
	{
		try
		{
			adapter = new RestAdapter.Builder().setEndpoint(Consts.LOGIN_API_URL).build();

			if (client == null)
			{
				client = new APIClient();

				blogApi = adapter.create(BlogAPI.class);

				response = blogApi.Login(username, EncodePassword(username, password));

				return response;

			}
			else
				return response;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static void Login()
	{

	}

	private static String EncodePassword(String username, String password)
	{
		String auth = new String(Base64.encode((username + ":" + password).getBytes(), Base64.URL_SAFE
				| Base64.NO_WRAP));

		return "Basic " + auth;

	}

}
