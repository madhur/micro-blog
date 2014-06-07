package com.axp.amexmicroblog.tasks;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.api.APIClient;

import android.content.Context;
import android.os.AsyncTask;

public abstract class BaseTask extends AsyncTask<TaskRequest, Integer, Object>
{
	protected APIClient client;
	protected Context context;
	private TaskListener listener;

	public BaseTask(Context context, TaskListener listener)
	{
		this.context=context;
		this.listener=listener;
	}

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();

		listener.OnTaskStarted();
		
		App app = (App) context.getApplicationContext();
		if (app.getApiClient() != null)
		{
			client = app.getApiClient();
		}

	}
	
	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);
		
		listener.OnTaskFinished(result);
	}

}
