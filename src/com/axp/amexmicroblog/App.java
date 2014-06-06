package com.axp.amexmicroblog;

import com.axp.amexmicroblog.api.APIClient;
import com.axp.amexmicroblog.api.LoginResponse;

import android.app.Application;

public class App extends Application
{
	
	private LoginResponse loginResponse;
	private APIClient apiClient;

	public LoginResponse getLoginResponse()
	{
		return loginResponse;
	}

	public void setLoginResponse(LoginResponse loginResponse)
	{
		this.loginResponse = loginResponse;
	}

	public APIClient getApiClient()
	{
		return apiClient;
	}

	public void setApiClient(APIClient apiClient)
	{
		this.apiClient = apiClient;
	}

}
