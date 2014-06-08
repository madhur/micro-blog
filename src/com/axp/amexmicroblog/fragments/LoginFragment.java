package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.AppPreferences;
import com.axp.amexmicroblog.Consts;
import com.axp.amexmicroblog.LoginActivity;
import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.AppPreferences.Keys;
import com.axp.amexmicroblog.api.LoginResponse;
import com.axp.amexmicroblog.tasks.LoginTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

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
		progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
		loginPanel = (LinearLayout) v.findViewById(R.id.login_panel);

		Button loginButton = (Button) v.findViewById(R.id.LoginButton);
		Button registerButton = (Button) v.findViewById(R.id.RegisterButton);

		registerButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{

				LoginActivity activity = (LoginActivity) getActivity();
				activity.LoadRegisterFragment();

			}
		});

		loginButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				if (TextUtils.isEmpty(usernameEditText.getText().toString())
						|| TextUtils.isEmpty(passwordEditText.getText().toString()))
				{
					Crouton.showText(getActivity(), "Please fill in all fields", Style.ALERT);
					return;
				}

				new LoginTask(getActivity(), LoginFragment.this).execute(GetLoginRequestObj(usernameEditText.getText().toString(), passwordEditText.getText().toString()));
			}
		});

		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{

		AppPreferences appPreferences = new AppPreferences(getActivity());
		super.onActivityCreated(savedInstanceState);

		String userName = appPreferences.getMetadata(Keys.USERNAME);
		String password = appPreferences.getMetadata(Keys.PASSWORD);
		
		if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password))
			return;
		
		new LoginTask(getActivity(), LoginFragment.this).execute(GetLoginRequestObj(userName, password));

	}

	private TaskRequest GetLoginRequestObj(String username, String password)
	{
		TaskRequest creds = new TaskRequest();
		creds.setUsername(username);
		creds.setPassword(password);
		return creds;

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
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
					| Intent.FLAG_ACTIVITY_NEW_TASK);
			i.setClass(getActivity(), MainActivity.class);
			startActivity(i);

		}
		else
		{
			Crouton.showText(getActivity(), "Problem during login. Please check your username/password and connectivity", Style.ALERT);

		}

	}

}
