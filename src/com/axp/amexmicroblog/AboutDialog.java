package com.axp.amexmicroblog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;

public class AboutDialog extends DialogFragment
{
	private WebView webView;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(),android.R.style.Theme_DeviceDefault_Dialog));
		
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.about_view, null);
		webView = (WebView) v.findViewById(R.id.webview);
		webView.loadUrl("file:///android_asset/about.html");
		builder.setPositiveButton(android.R.string.ok, new OnClickListener()
		{

			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				dialog.dismiss();

			}
		});

		builder.setView(v);
		builder.setTitle("About this App");
		return builder.create();

	}

}
