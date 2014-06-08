package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.adapters.FollowerAdapter;
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

public class SearchResultsFragment extends BaseFragment
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
			
			FollowerAdapter adapter = new FollowerAdapter(responses, getActivity());

			resultsListView.setAdapter(adapter);
			
		}
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		inflater.inflate(R.menu.followers_menu, menu);

		// Associate searchable configuration with the SearchView
		SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search_user).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

		SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener()
		{
			TaskRequest req = new TaskRequest();

			@Override
			public boolean onQueryTextChange(String newText)
			{

				return true;
			}

			@Override
			public boolean onQueryTextSubmit(final String query)
			{
				req.setSearchString(query);

				new SearchUserTask(getActivity(), new TaskListener()
				{

					@Override
					public void OnTaskStarted()
					{
					}

					@Override
					public void OnTaskFinished(Object result)
					{
						String[] response = (String[]) result;

						if (response != null && response.length > 0)
						{

							MainActivity activity = (MainActivity) getActivity();
							activity.LoadResultsFragment(response);
							
							
							
						}
						else
						{
							Crouton.showText(getActivity(), "No users found with specified search", Style.CONFIRM);
						}
					}
				}).execute(req);

				return true;
			}

		};
		searchView.setOnQueryTextListener(textChangeListener);

	}

}
