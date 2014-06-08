package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;

public class SearchUserTask extends BaseTask
{

	public SearchUserTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}

	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		try
		{
			return client.SearchUsers(params[0].getSearchString());
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
	}

}
