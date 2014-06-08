package com.axp.amexmicroblog.tasks;

import android.content.Context;
import android.util.Log;

import com.axp.amexmicroblog.Consts;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.api.APIClient;

public class CreateUserTask extends BaseTask
{

	public CreateUserTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}

	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		String result = "";

		try
		{
			APIClient.CreateUser(params[0].getTargetUser(), params[0].getTargetUserPassword());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			if (e.getMessage() != null)
			{
				Log.e(Consts.TAG, e.getMessage());
				result = e.getMessage();
			}
			else
			{
				Log.e(Consts.TAG, "Error while registering");
				return "Error during Registration";
			}

		}

		return result;
	}

}
