package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;

public class PostTask extends BaseTask
{

	public PostTask(Context context, TaskListener listener)
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
		String result;
		try
		{
			result=client.CreatePost(params[0].getPostMessage());
		}
		catch (Exception e)
		{
			result= e.getMessage();
		}

		return result;

	}
}
