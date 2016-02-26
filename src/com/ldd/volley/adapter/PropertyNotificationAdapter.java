package com.ldd.volley.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ldd.volley.R;
import com.ldd.volley.bean.Notes;


public class PropertyNotificationAdapter extends BaseAdapter {
	private List<Notes> mList;
	private Context mContext;
	private boolean mStoped;
	private int mCount;
	
	public PropertyNotificationAdapter(Context ctx, List<Notes> list) 
	{
		this.mContext = ctx;
		this.mList = list;
		this.mStoped = false;
		this.mCount = mList.size();
	}
	
	public void appandAdapter(List<Notes> list) 
	{
		for(int i=0; i<list.size(); i++)
		{
			mList.add(list.get(i));
			mCount++;
		}
	}
	

	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		if(mStoped)
			return convertView;
		ActivityItem activityItem;
		final Notes activity = mList.get(position);
		if (convertView == null) 
		{
			View v = LayoutInflater.from(mContext).inflate(R.layout.main_radio2_list_item, null);
			activityItem = new ActivityItem();
			activityItem.mProductMessageTitleTextView = (TextView) v.findViewById(R.id.ProductMessageTitleTextView);
			activityItem.mProductMessageTimeTextView = (TextView) v.findViewById(R.id.ProductMessageTimeTextView);
			activityItem.mProductMessageContentTextView=(TextView) v.findViewById(R.id.ProductMessageContentTextView);
			activityItem.mMainRadio4ListItemLinearLayout = (LinearLayout) v.findViewById(R.id.MainRadio4ListItemLinearLayout);
			v.setTag(activityItem);
			convertView = v;
		} 
		else 
		{
			activityItem = (ActivityItem)convertView.getTag();
		}
		activityItem.mProductMessageTitleTextView.setText(activity.getHeader());
		activityItem.mProductMessageTimeTextView.setText(activity.getCTime());
		Log.i("MyLog", "time==="+activity.getCTime());
		activityItem.mProductMessageContentTextView.setText(activity.getBody());
		activityItem.mMainRadio4ListItemLinearLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Intent intent=new Intent();
				intent.setClass(mContext, Notes.class);
				intent.putExtra("productMessageInfoTitle", activity.getHeader());
				intent.putExtra("productMessageInfoTime", activity.getCTime());
				intent.putExtra("productMessageInfoContent", activity.getBody());
				intent.putExtra("productMessageInfoSignature", activity.getSignature());
				mContext.startActivity(intent);*/
				Toast.makeText(mContext, "µã»÷ÁË"+activity.getPropertyID(), Toast.LENGTH_SHORT).show();
			}
		});
		
		return convertView;
	}

	class ActivityItem 
	{
		TextView mProductMessageTitleTextView;
		TextView mProductMessageTimeTextView;
		TextView mProductMessageContentTextView;
		LinearLayout mMainRadio4ListItemLinearLayout;
	}
}
