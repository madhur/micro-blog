package com.axp.amexmicroblog;

import com.axp.amexmicroblog.api.LoginResponse;

import android.app.Application;

public class App extends Application
{
	
	private LoginResponse loginResponse;

	public LoginResponse getLoginResponse()
	{
		return loginResponse;
	}

	public void setLoginResponse(LoginResponse loginResponse)
	{
		this.loginResponse = loginResponse;
	}

}
