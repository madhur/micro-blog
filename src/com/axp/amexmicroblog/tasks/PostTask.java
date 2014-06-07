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
	protected Object doInBackground(Credentials... params)
	{
		
	}

}
