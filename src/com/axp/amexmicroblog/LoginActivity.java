package com.axp.amexmicroblog;

import com.axp.amexmicroblog.fragments.CreateUserFragment;
import com.axp.amexmicroblog.fragments.LoginFragment;

import android.app.Activity;
import android.os.Bundle;

public class LoginActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		LoadLoginFragment();
		
	}
	
	public void LoadLoginFragment()
	{
		getFragmentManager().beginTransaction().addToBackStack("login").replace(android.R.id.content, new LoginFragment()).commit();
		
	}
	
	public void LoadRegisterFragment()
	{
		getFragmentManager().beginTransaction().addToBackStack("register").replace(android.R.id.content, new CreateUserFragment()).commit();
		
	}
	
}
