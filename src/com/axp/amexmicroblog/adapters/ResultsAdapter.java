package com.axp.amexmicroblog.adapters;

import java.util.Arrays;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.tasks.FollowTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.TextView;

public class ResultsAdapter extends FollowerAdapter
{

	public ResultsAdapter(String[] followers, Context context)
	{
		super(followers, context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		
		View v = null;
		if (convertView == null)
		{
			v = LayoutInflater.from(context).inflate(R.layout.follower_item, null);

		}
		else
			v = convertView;

		TextView follower = (TextView) v.findViewById(com.axp.amexmicroblog.R.id.follower_TextView);
		Switch followerSwitch = (Switch) v.findViewById(com.axp.amexmicroblog.R.id.followerSwitch);

		followerSwitch.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				final String userName = (String) v.getTag();

				Switch followSwitch = (Switch) v;

				TaskRequest request = new TaskRequest();
				request.setTargetUser(userName);
				request.setFollow(followSwitch.isChecked());

				new FollowTask(context, new TaskListener()
				{

					@Override
					public void OnTaskStarted()
					{

					}

					@Override
					public void OnTaskFinished(Object result)
					{
						Crouton.showText((Activity) context, "Successfully saved changes for "
								+ userName, Style.INFO);
					}
				}).execute(request);

			}
		});

		follower.setText((CharSequence) getItem(position));

		followerSwitch.setTag((CharSequence) getItem(position));

		App app = (App) context.getApplicationContext();

		if (app.getFollowers() != null
				&& Arrays.asList(app.getFollowers()).contains(getItem(position)))
		{
			followerSwitch.setChecked(true);
		}
		else
			followerSwitch.setTag((CharSequence) getItem(position));

		return v;

	}
}
