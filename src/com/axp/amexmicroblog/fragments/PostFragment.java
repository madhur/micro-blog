package com.axp.amexmicroblog.fragments;

import com.axp.amexmicroblog.MainActivity;
import com.axp.amexmicroblog.R;
import com.axp.amexmicroblog.TaskListener;
import com.axp.amexmicroblog.tasks.PostTask;
import com.axp.amexmicroblog.tasks.TaskRequest;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PostFragment extends BaseFragment implements TaskListener
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
	public void onAttach(Activity activity)
	{
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
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
			 TaskRequest postRequest=new TaskRequest();
			 postRequest.setPostMessage(postEditText.getText().toString());
			 new PostTask(getActivity(), this).execute(postRequest);
			 
			 
			 return true;
		 }
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void OnTaskStarted()
	{
		
	}

	@Override
	public void OnTaskFinished(Object result)
	{
		
		if(TextUtils.isEmpty((CharSequence) result))
		{
			Crouton.showText(getActivity(), "Your post was successfully published", Style.INFO);
			
			MainActivity main=(MainActivity) getActivity();
			main.LoadMainFragment();
			
		}
		else
		{
			Crouton.showText(getActivity(), (CharSequence) result, Style.ALERT);
			
		}
	}

}
