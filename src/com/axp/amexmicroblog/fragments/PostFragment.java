package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PostFragment extends BaseFragment
{
	private EditText postEditText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		View v=inflater.inflate(R.layout.fragment_post, container, false);
		postEditText=(EditText) v.findViewById(R.id.postEditText);
		return v;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.post_menu, menu);
	}
	
	 @Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		 if(item.getItemId()==R.id.post_blog)
		 {
			 
			 
			 
			 return true;
		 }
		return super.onOptionsItemSelected(item);
	}

}
