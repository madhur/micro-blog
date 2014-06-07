package com.axp.amexmicroblog.adapters;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter extends BaseAdapter
{
	protected Context context;
	
	public MyBaseAdapter(Context context)
	{
		this.context=context;
		
	}

}
