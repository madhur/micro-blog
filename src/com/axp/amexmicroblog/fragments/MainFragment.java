package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.MessagesAdapter;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.R.id;
import com.axp.amexmicroblog.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MainFragment extends Fragment
{
	private ListView messagesListView;
	private MessagesAdapter messagesAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View v = inflater.inflate(R.layout.fragment_main, container, false);
		return v;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		super.onCreateOptionsMenu(menu, inflater);
		
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		messagesListView=(ListView) getView().findViewById(R.id.messagesListView);
		
		App app=(App) getActivity().getApplicationContext();
		
		if(app.getLoginResponse()!=null)
		{
			
			messagesAdapter=new MessagesAdapter(app.getLoginResponse().getContent(), getActivity());
			
			messagesListView.setAdapter(messagesAdapter);
		}
		
	}

	

}
