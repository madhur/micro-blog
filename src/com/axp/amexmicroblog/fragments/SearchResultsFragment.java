package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.adapters.FollowerAdapter;
import com.axp.amexmicroblog.adapters.ResultsAdapter;
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

public class SearchResultsFragment extends SearchFragment
{
	private ListView resultsListView;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v=inflater.inflate(R.layout.fragment_searchresults, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		
		resultsListView = (ListView) getView().findViewById(R.id.searchResultsListView);
		
		String responses[];
		
		Bundle data=getArguments();
		if(data!=null)
		{
			responses=data.getStringArray("followers");
			
			ResultsAdapter adapter = new ResultsAdapter(responses, getActivity());

			resultsListView.setAdapter(adapter);
			
		}
	}
	
}
