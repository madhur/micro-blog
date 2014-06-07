package com.axp.amexmicroblog.fragments;

import java.util.ArrayList;

import com.axp.amexmicroblog.App;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.adapters.MessagesAdapter;
import com.axp.amexmicroblog.api.Content;
import com.axp.amexmicroblog.api.LoginResponse;
import com.axp.amexmicroblog.tasks.LoginTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainFragment extends BaseFragment implements TaskListener
{
	private ListView messagesListView;
	private MessagesAdapter messagesAdapter;
	private ProgressBar progressBar;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
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
		inflater.inflate(R.menu.main_menu, menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (item.getItemId() == R.id.add_post)
		{

		}
		else if (item.getItemId() == R.id.refresh)
		{
			new LoginTask(getActivity(), MainFragment.this).execute(new TaskRequest());
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		messagesListView = (ListView) getView().findViewById(R.id.messagesListView);
		progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);

		new LoginTask(getActivity(), MainFragment.this).execute(new TaskRequest());

	}

	@Override
	public void OnTaskStarted()
	{
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void OnTaskFinished(Object result)
	{

		progressBar.setVisibility(View.GONE);

		LoginResponse response = (LoginResponse) result;
		if (response != null)
		{
			if (messagesAdapter != null)
			{
				messagesAdapter.SetMessages((ArrayList<Content>) (response.getContent()));
				messagesAdapter.notifyDataSetChanged();
			}
			else
			{
				messagesAdapter = new MessagesAdapter(response.getContent(), getActivity());
				messagesListView.setAdapter(messagesAdapter);
			}

		}

	}

}
