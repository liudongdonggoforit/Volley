package com.ldd.volley.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.ldd.volley.R;
import com.ldd.volley.application.VolleyApplication;
import com.ldd.volley.bean.Fleas;
import com.ldd.volley.utils.BitmapCache;
import com.ldd.volley.utils.ImageCacheManger;


public class ProductListAdapter extends BaseAdapter
{

	private List<Fleas> mList;
	private Context mContext;

	public ProductListAdapter(Context ctx, List<Fleas> list)
	{
		this.mContext = ctx;
		this.mList = list;
	}
	@Override
	public int getCount()
	{
		return mList.size();
	}

	@Override
	public Object getItem(int position)
	{
		return mList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent)
	{
		final ProductItem productItem;
		final Fleas info = mList.get(position);
		if (convertView == null)
		{

			View v = LayoutInflater.from(mContext).inflate(R.layout.listview_search_item2, null);
			productItem = new ProductItem();
			productItem.mProductIcon = (ImageView) v.findViewById(R.id.item_icon);
			productItem.mProductTime = (TextView) v.findViewById(R.id.item_time);
			productItem.mProductTitle = (TextView) v.findViewById(R.id.item_title);
			productItem.mProductContent = (TextView) v.findViewById(R.id.item_content);
			productItem.mItemBackground = (LinearLayout) v.findViewById(R.id.product_list_item_bg);
			productItem.mArrow = (ImageView) v.findViewById(R.id.item_image_arrow);
			v.setTag(productItem);
			convertView = v;
		} else
		{
			productItem = (ProductItem) convertView.getTag();
		}
//
//		if (position == 0)
//			productItem.mItemBackground.setBackgroundResource(R.drawable.style_item_top);
//		else if (position == mList.size() - 1)
//			productItem.mItemBackground.setBackgroundResource(R.drawable.style_item_bottom);
//		else
//			productItem.mItemBackground.setBackgroundResource(R.drawable.style_item_center);

		if (info.getFrontCover().getPath() == null)
			productItem.mProductIcon.setImageResource(R.drawable.ic_launcher);
		else
			Log.i("MyLog", "url a ="+info.getFrontCover().getPath());
		ImageCacheManger.loadImage(info.getFrontCover().getPath(), productItem.mProductIcon,getBitmapFromResources(mContext, R.drawable.ic_launcher), getBitmapFromResources(mContext, R.drawable.ic_launcher), 0, 0);
//			productItem.mProductIcon.setImageDrawable(info.frontCover.imgDw);
		
		productItem.mProductTime.setText(info.getCTime());
		productItem.mProductTitle.setText(info.getHeader());
		productItem.mProductContent.setText(info.getDescription());
		Log.i("MyLog", "url="+info.getFrontCover().getPath());

		productItem.mItemBackground.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(mContext, "123", Toast.LENGTH_LONG).show();
			}
		});

		return convertView;
	}
	
	/**
     * 从资源中取出Bitmap
     * @param mContext2
     * @param resId
     * @return
     */
    public static Bitmap getBitmapFromResources(Context mContext2, int resId) {
        Resources res = mContext2.getResources();
        return BitmapFactory.decodeResource(res, resId);
    }

	class ProductItem
	{
		LinearLayout mItemBackground;
		ImageView mProductIcon;
		TextView mProductTime;
		TextView mProductTitle;
		TextView mProductContent;
		ImageView mArrow;
	}
}
