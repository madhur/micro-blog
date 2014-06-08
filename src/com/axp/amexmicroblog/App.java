package com.axp.amexmicroblog;

import com.axp.amexmicroblog.api.APIClient;
import com.axp.amexmicroblog.api.LoginResponse;

import android.app.Application;

public class App extends Application
{
	
	private APIClient apiClient;
	private String[] followers;
	

	public APIClient getApiClient()
	{
		return apiClient;
	}

	public void setApiClient(APIClient apiClient)
	{
		this.apiClient = apiClient;
	}

	public String[] getFollowers()
	{
		return followers;
	}

	public void setFollowers(String[] followers)
	{
		this.followers = followers;
	}

}
