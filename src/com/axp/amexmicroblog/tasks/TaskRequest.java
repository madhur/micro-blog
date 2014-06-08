package com.axp.amexmicroblog.tasks;

public class TaskRequest
{
	private String username;
	private String password;
	private String postMessage;
	private String targetUser;
	private String targetUserPassword;
	private boolean isFollow;
	private String searchString;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPostMessage()
	{
		return postMessage;
	}
	public void setPostMessage(String postMessage)
	{
		this.postMessage = postMessage;
	}
	public String getTargetUser()
	{
		return targetUser;
	}
	public void setTargetUser(String targetUser)
	{
		this.targetUser = targetUser;
	}
	public boolean isFollow()
	{
		return isFollow;
	}
	public void setFollow(boolean isFollow)
	{
		this.isFollow = isFollow;
	}
	public String getTargetUserPassword()
	{
		return targetUserPassword;
	}
	public void setTargetUserPassword(String targetUserPassword)
	{
		this.targetUserPassword = targetUserPassword;
	}
	public String getSearchString()
	{
		return searchString;
	}
	public void setSearchString(String searchString)
	{
		this.searchString = searchString;
	}

}
