package com.axp.amexmicroblog;

import com.axp.amexmicroblog.api.APIClient;
import com.axp.amexmicroblog.api.LoginResponse;

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
import android.widget.Toast;

public class LoginFragment extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View v = inflater.inflate(R.layout.fragment_login, null);

		final EditText usernameEditText = ((EditText) v.findViewById(R.id.UserNameEditText));
		final EditText passwordEditText = ((EditText) v.findViewById(R.id.PasswordEditText));

		Button loginButton = (Button) v.findViewById(R.id.LoginButton);
		loginButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				new LoginTask(usernameEditText.getText().toString(), passwordEditText.getText().toString()).execute(0);
			}
		});

		return v;
	}

	private class LoginTask extends AsyncTask<Integer, Integer, LoginResponse>
	{
		String username, password;

		public LoginTask(String username, String password)
		{
			this.username = username;
			this.password = password;
		}

		@Override
		protected void onPreExecute()
		{
			super.onPreExecute();
			Toast.makeText(getActivity(), "Authenticating", Toast.LENGTH_SHORT).show();
		}

		@Override
		protected LoginResponse doInBackground(Integer... params)
		{

			LoginResponse response = null;
			try
			{
				response = APIClient.getInstance(username, password);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			return response;
		}

		@Override
		protected void onPostExecute(LoginResponse result)
		{
			super.onPostExecute(result);
			if (result != null)
			{
				Log.v(Consts.TAG, result.toString());

				App app = (App) getActivity().getApplicationContext();

				app.setLoginResponse(result);
				
				Intent i = new Intent();
				i.setClass(getActivity(), MainActivity.class);
				startActivity(i);

			}
			else
				Log.v(Consts.TAG, "is null");

		}

	}

}
