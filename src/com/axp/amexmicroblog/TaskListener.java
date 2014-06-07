package com.axp.amexmicroblog;

public interface TaskListener
{
	
	void OnTaskStarted();
	void OnTaskFinished(Object result);

}
