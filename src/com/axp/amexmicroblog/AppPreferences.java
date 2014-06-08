package com.axp.amexmicroblog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class AppPreferences
{
	
	private SharedPreferences sharedPreferences;

	public AppPreferences(Context context)
	{
		this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public enum Keys
	{
		
		USERNAME("username"),
		PASSWORD("password");
		
		public final String key;

		private Keys(String key)
		{
			this.key = key;

		}

	}
	
	public void ClearTokens()
	{
		SaveCredentials("", "");
	}
	
	public String getMetadata(Keys key)
	{
		return sharedPreferences.getString(key.key, "");
	}
	
	public void SaveCredentials(String username, String password)
	{

		Editor edit = sharedPreferences.edit();
		edit.putString(Keys.USERNAME.key,username);
		edit.putString(Keys.PASSWORD.key, password);
		
		edit.commit();

	}

}
