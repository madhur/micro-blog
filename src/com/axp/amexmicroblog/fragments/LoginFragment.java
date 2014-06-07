package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.Consts;
import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.api.APIClient;
import com.axp.amexmicroblog.api.LoginResponse;
import com.axp.amexmicroblog.tasks.Credentials;
import com.axp.amexmicroblog.tasks.LoginTask;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginFragment extends Fragment implements TaskListener
{

	private ProgressBar progressBar;
	private LinearLayout loginPanel;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View v = inflater.inflate(R.layout.fragment_login, null);

		final EditText usernameEditText = ((EditText) v.findViewById(R.id.UserNameEditText));
		final EditText passwordEditText = ((EditText) v.findViewById(R.id.PasswordEditText));
		progressBar=(ProgressBar) v.findViewById(R.id.progress_bar);
		loginPanel=(LinearLayout) v.findViewById(R.id.login_panel);
		
		Button loginButton = (Button) v.findViewById(R.id.LoginButton);
		loginButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				Credentials creds=new Credentials();
				creds.setUsername(usernameEditText.getText().toString());
				creds.setPassword(passwordEditText.getText().toString());
				
				new LoginTask(getActivity(), LoginFragment.this).execute(creds);
			}
		});

		return v;
	}

	@Override
	public void OnTaskStarted()
	{
		progressBar.setVisibility(View.VISIBLE);
		loginPanel.setVisibility(View.GONE);
	}

	@Override
	public void OnTaskFinished(Object result)
	{
		progressBar.setVisibility(View.GONE);
		loginPanel.setVisibility(View.VISIBLE);
		
		if (result != null)
		{
			Log.v(Consts.TAG, result.toString());

			App app = (App) getActivity().getApplicationContext();

			app.setLoginResponse((LoginResponse) result);
			
			
			Intent i = new Intent();
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
			i.setClass(getActivity(), MainActivity.class);
			startActivity(i);

		}
		else
			Log.v(Consts.TAG, "is null");

	}

}
