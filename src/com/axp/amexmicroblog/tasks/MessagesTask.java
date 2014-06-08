package com.axp.amexmicroblog.tasks;

import android.content.Context;

import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.api.LoginResponse;

public class MessagesTask extends BaseTask
{

	public MessagesTask(Context context, TaskListener listener)
	{
		super(context, listener);
	}
	
	@Override
	protected Object doInBackground(TaskRequest... params)
	{
		LoginResponse response=client.GetMessageList();
		return response;
	}

}
