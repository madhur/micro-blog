package com.axp.amexmicroblog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;
import com.axp.amexmicroblog.R;

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
		
		follower.setText((CharSequence) getItem(position));
		followerSwitch.setChecked(true);
		
		return v;
		
	}

	

}
