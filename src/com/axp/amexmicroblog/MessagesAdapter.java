package com.axp.amexmicroblog;

import java.util.ArrayList;
import java.util.List;

import com.axp.amexmicroblog.api.Content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MessagesAdapter extends BaseAdapter
{
	private ArrayList<Content> messages;
	private Context context;

	public MessagesAdapter()
	{

	}

	public MessagesAdapter(List<Content> content, Context context)
	{
		this.messages = (ArrayList<Content>) content;
		this.context=context;
	}

	@Override
	public int getCount()
	{
		return messages.size();
	}

	@Override
	public Object getItem(int position)
	{
		return messages.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View view = null;
		ViewHolder holder;
		if (convertView == null)
		{
			LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = li.inflate(R.layout.messages_item, parent, false);

			holder = new ViewHolder();
			holder.message = (TextView) view.findViewById(R.id.messageTextView);
			holder.age = (TextView) view.findViewById(R.id.ageTextView);

			view.setTag(holder);

		}
		else
		{
			view = convertView;
			holder = (ViewHolder) view.getTag();
		}

		Content content = (Content) getItem(position);

		holder.message.setText(content.getMessage());
		holder.age.setText(content.getAge());

		return view;
	}

	private static class ViewHolder
	{
		TextView message;
		TextView user;
		TextView age;

	}

}
