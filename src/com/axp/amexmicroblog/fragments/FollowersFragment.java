package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.adapters.FollowerAdapter;
import com.axp.amexmicroblog.tasks.GetFollowersTask;
import com.axp.amexmicroblog.tasks.SearchUserTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

public class FollowersFragment extends SearchFragment implements TaskListener
{
	private ListView followersListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_follower, container, false);
		return v;

	}

	

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		followersListView = (ListView) getView().findViewById(R.id.followersListView);
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
		
		if(followers.length==0)
		{
			Crouton.showText(getActivity(), "You do not have any followers", Style.INFO);
			return;
		}
		
		App app=(App) getActivity().getApplicationContext();
		app.setFollowers(followers);
		
		FollowerAdapter adapter = new FollowerAdapter(followers, getActivity());

		followersListView.setAdapter(adapter);

	}

}
