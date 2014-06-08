package com.axp.amexmicroblog;

import com.axp.amexmicroblog.fragments.FollowersFragment;
import com.axp.amexmicroblog.fragments.MainFragment;
import com.axp.amexmicroblog.fragments.PostFragment;
import com.axp.amexmicroblog.fragments.SearchResultsFragment;

import de.keyboardsurfer.android.widget.crouton.Crouton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPlanetTitles = getResources().getStringArray(R.array.drawer_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close)
		{

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view)
			{
				super.onDrawerClosed(view);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView)
			{
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		LoadMainFragment();

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if (mDrawerToggle.onOptionsItemSelected(item))
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		// If the nav drawer is open, hide action items related to the content
		// view
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		// menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView parent, View view, int position, long id)
		{
			selectItem(position);
		}
	}

	public void LoadMainFragment()
	{
		Fragment fragment = new MainFragment();
		getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

	}
	
	public void LoadResultsFragment(String[] response)
	{
		Fragment fragment=new SearchResultsFragment();
		Bundle data=new Bundle();
		
		data.putStringArray("followers", response);
		fragment.setArguments(data);
		getFragmentManager().beginTransaction().addToBackStack("search").replace(R.id.content_frame, fragment).commit();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Crouton.cancelAllCroutons();

	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position)
	{
		Fragment fragment;

		switch (position)
		{
			case 0:
				LoadMainFragment();
				break;

			case 1:
				fragment = new FollowersFragment();
				getFragmentManager().beginTransaction().addToBackStack("followers").replace(R.id.content_frame, fragment).commit();
				break;

			case 2:
				fragment = new PostFragment();
				getFragmentManager().beginTransaction().addToBackStack("post").replace(R.id.content_frame, fragment).commit();
				break;

			case 3:
				AlertDialog.Builder builder = new Builder(this);
				builder.setMessage("Are you sure you want to logout?").setTitle(R.string.app_name).setPositiveButton(android.R.string.ok, new OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						new AppPreferences(MainActivity.this).ClearTokens();
						
						Intent i = new Intent();
						i.setClass(MainActivity.this, LoginActivity.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
								| Intent.FLAG_ACTIVITY_NEW_TASK);

						startActivity(i);
					}
				});
				builder.setNegativeButton(android.R.string.cancel, new OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});

				builder.show();
				break;

			case 4:
				AboutDialog dialog = new AboutDialog();
				dialog.show(getFragmentManager(), "about");
				break;

		}

		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	public void setTitle(CharSequence title)
	{
		getActionBar().setTitle(title);
	}

}
