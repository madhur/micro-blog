package com.axp.amexmicroblog.tasks;

import android.content.Context;
import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.api.APIClient;
import com.axp.amexmicroblog.api.LoginResponse;

public class LoginTask extends BaseTask
{

	public LoginTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}

	String username, password;
	APIClient client;

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		
	}

	@Override
	protected LoginResponse doInBackground(TaskRequest... params)
	{

		LoginResponse response = null;
		try
		{
			client = APIClient.getInstance(params[0].getUsername(), params[0].getPassword());
			response=client.GetMessageList();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return response;
	}
	
	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);
		
		App app = (App) context.getApplicationContext();
		app.setApiClient(client);
		
	}

}
