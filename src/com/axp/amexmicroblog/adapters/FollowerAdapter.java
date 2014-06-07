package com.axp.amexmicroblog.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.tasks.FollowTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class FollowerAdapter extends MyBaseAdapter
{
	private String[] followers;
	
	public FollowerAdapter(String[] followers, Context context)
	{
		super(context);
		this.followers=followers;
	}

	@Override
	public int getCount()
	{
		return followers.length;
	}

	@Override
	public Object getItem(int position)
	{
		return followers[position];
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View v=null;
		if(convertView==null)
		{
			v=LayoutInflater.from(context).inflate(R.layout.follower_item, null);
			
		}
		else
			v=convertView;
		
		TextView follower=(TextView) v.findViewById(com.axp.amexmicroblog.R.id.follower_TextView);
		Switch followerSwitch=(Switch) v.findViewById(com.axp.amexmicroblog.R.id.followerSwitch);
		
		followerSwitch.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				final String userName=(String)  v.getTag();
				
				Switch followSwitch=(Switch) v;
				
				TaskRequest request=new TaskRequest();
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
		//				if(TextUtils.isEmpty((CharSequence) result))
			//			{
							Crouton.showText((Activity) context, "Successfully saved changes for " + userName, Style.INFO);
				//		}
	//					else
//							Crouton.showText((Activity) context, (CharSequence) result, Style.INFO);
					}
				}).execute(request);
				
			}
		});
		
		follower.setText((CharSequence) getItem(position));
		followerSwitch.setChecked(true);
		
		followerSwitch.setTag((CharSequence) getItem(position));
		
		return v;
		
	}

	

}
