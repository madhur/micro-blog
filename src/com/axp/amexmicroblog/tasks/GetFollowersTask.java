package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;

public class GetFollowersTask extends BaseTask
{
	public GetFollowersTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}
	

	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);

	}
	
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}


	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		String response[] = client.GetFollowers();
		return response;
	}

}
