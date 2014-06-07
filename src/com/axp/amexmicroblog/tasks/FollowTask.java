package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;

public class FollowTask extends BaseTask
{

	public FollowTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);
	}

	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		String result="";
		try
		{
			client.SetUserStatus(params[0].getTargetUser(), params[0].isFollow());
		}
		catch (Exception e)
		{
			result = e.getMessage();
		}
		
		return result;

	}

}
