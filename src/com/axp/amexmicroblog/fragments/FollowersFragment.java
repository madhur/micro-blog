package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.adapters.FollowerAdapter;
import com.axp.amexmicroblog.tasks.GetFollowersTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FollowersFragment extends BaseFragment implements TaskListener
{
	private ListView followersListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v=inflater.inflate(R.layout.fragment_follower, container, false);
		return v;
		
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.followers_menu, menu);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		followersListView= (ListView) getView().findViewById(R.id.followersListView);
		new GetFollowersTask(getActivity(), FollowersFragment.this).execute(new TaskRequest());
		
	}

	@Override
	public void OnTaskStarted()
	{
		
	}

	@Override
	public void OnTaskFinished(Object result)
	{
		String followers[] = (String[]) result;

		FollowerAdapter adapter = new FollowerAdapter(followers, getActivity());

		followersListView.setAdapter(adapter);
		
	}

}
