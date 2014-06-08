package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.LoginActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.tasks.CreateUserTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class CreateUserFragment extends BaseFragment implements TaskListener
{
	private EditText username, password, email;
	private Button registerButton;
	
	private ProgressBar progressBar;
	private LinearLayout loginPanel;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		View v=inflater.inflate(R.layout.fragment_createuser, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		username=(EditText) getView().findViewById(R.id.UserNameEditText);
		password=(EditText) getView().findViewById(R.id.PasswordEditText);
		email=(EditText) getView().findViewById(R.id.EmailEditText);
		
		progressBar=(ProgressBar) getView().findViewById(R.id.progress_bar);
		loginPanel=(LinearLayout) getView().findViewById(R.id.login_panel);
		
		registerButton=(Button) getView().findViewById(R.id.RegisterButton);
		
		registerButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				String userNameText=username.getText().toString();
				String userNamepassword=password.getText().toString();
				String emailText=email.getText().toString();
				
				if(TextUtils.isEmpty(userNameText) || TextUtils.isEmpty(userNamepassword) || TextUtils.isEmpty(emailText))
				{
					Crouton.showText(getActivity(), "Please fill in all fields", Style.ALERT);
					return;
				}
				
				TaskRequest req=new TaskRequest();
				req.setUsername(userNameText);
				req.setPassword(userNamepassword);
				
				new CreateUserTask(getActivity(), CreateUserFragment.this).execute(req);
				
				
			}
		});
		
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
		
		if(!TextUtils.isEmpty((CharSequence) result))
		{
			Crouton.showText(getActivity(), (CharSequence) result, Style.ALERT);
			return;
		}
		
		Crouton.showText(getActivity(), "Registered Successfully", Style.INFO);
		
		LoginActivity activity=(LoginActivity) getActivity();
		activity.LoadLoginFragment();
	}
	
	

}
