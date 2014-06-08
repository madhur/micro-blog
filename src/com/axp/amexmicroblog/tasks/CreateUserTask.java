package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;

public class CreateUserTask extends BaseTask
{

	public CreateUserTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}

	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		String result="";

		try
		{
			client.CreateUser(params[0].getTargetUser(), params[0].getTargetUserPassword());
		}
		catch (Exception e)
		{
			result = e.getMessage();
		}

		return result;
	}

}
