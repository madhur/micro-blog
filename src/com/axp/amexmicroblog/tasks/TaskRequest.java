package com.axp.amexmicroblog.tasks;

public class TaskRequest
{
	private String username;
	private String password;
	private String postMessage;
	private String targetUser;
	private boolean isFollow;
	
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

}
