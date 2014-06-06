package com.axp.amexmicroblog;

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

		getFragmentManager().beginTransaction().replace(android.R.id.content, new LoginFragment()).commit();
	}
	
}
